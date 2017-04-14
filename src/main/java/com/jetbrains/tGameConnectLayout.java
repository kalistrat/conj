package com.jetbrains;


import com.vaadin.data.fieldgroup.Caption;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.io.IOException;
import java.io.OutputStream;


/**
 * Created by kalistrat on 13.04.2017.
 */
public class tGameConnectLayout extends VerticalLayout {

    private Label status = new Label("Please select a file to upload");

    private ProgressIndicator pi = new ProgressIndicator();

    private MyReceiver receiver = new MyReceiver();

    private HorizontalLayout progressLayout = new HorizontalLayout();

    private Upload upload = new Upload(null, receiver);

    public tGameConnectLayout(){

        setSpacing(true);

        // Slow down the upload
        receiver.setSlow(true);

        addComponent(status);
        addComponent(upload);
        addComponent(progressLayout);

        // Make uploading start immediately when file is selected
        upload.setImmediate(true);
        upload.setButtonCaption("Изменить аватар");
        //upload.setIcon(VaadinIcons.PICTURE);
        upload.addStyleName("myCustomUploadTiny");
        upload.addStyleName("upload-with-icon");


        progressLayout.setSpacing(true);
        progressLayout.setVisible(false);
        progressLayout.addComponent(pi);
        progressLayout.setComponentAlignment(pi, Alignment.MIDDLE_LEFT);

        final Button cancelProcessing = new Button("Cancel");
        cancelProcessing.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                upload.interruptUpload();
            }
        });
        cancelProcessing.setStyleName("small");
        progressLayout.addComponent(cancelProcessing);

        /**
         * =========== Add needed listener for the upload component: start,
         * progress, finish, success, fail ===========
         */

        upload.addListener(new Upload.StartedListener() {
            public void uploadStarted(Upload.StartedEvent event) {
                // This method gets called immediatedly after upload is started
                upload.setVisible(false);
                progressLayout.setVisible(true);
                pi.setValue(0f);
                pi.setPollingInterval(500);
                status.setValue("Uploading file \"" + event.getFilename()
                        + "\"");
            }
        });

        upload.addListener(new Upload.ProgressListener() {
            public void updateProgress(long readBytes, long contentLength) {
                // This method gets called several times during the update
                pi.setValue(new Float(readBytes / (float) contentLength));
            }

        });

        upload.addListener(new Upload.SucceededListener() {
            public void uploadSucceeded(Upload.SucceededEvent event) {
                // This method gets called when the upload finished successfully
                status.setValue("Uploading file \"" + event.getFilename()
                        + "\" succeeded");
            }
        });

        upload.addListener(new Upload.FailedListener() {
            public void uploadFailed(Upload.FailedEvent event) {
                // This method gets called when the upload failed
                status.setValue("Uploading interrupted");
            }
        });

        upload.addListener(new Upload.FinishedListener() {
            public void uploadFinished(Upload.FinishedEvent event) {
                // This method gets called always when the upload finished,
                // either succeeding or failing
                progressLayout.setVisible(false);
                upload.setVisible(true);
                upload.setCaption("Select another file");
            }
        });

    }

    public static class MyReceiver implements Upload.Receiver {

        private String fileName;
        private String mtype;
        private boolean sleep;
        private int total = 0;

        public OutputStream receiveUpload(String filename, String mimetype) {
            fileName = filename;
            mtype = mimetype;
            return new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    total++;
                    if (sleep && total % 10000 == 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            };
        }

        public String getFileName() {
            return fileName;
        }

        public String getMimeType() {
            return mtype;
        }

        public void setSlow(boolean value) {
            sleep = value;
        }

    }
}
