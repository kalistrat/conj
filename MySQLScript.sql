-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.5.23 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры для таблица conjuncture.area_field
CREATE TABLE IF NOT EXISTS `area_field` (
  `area_field_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_type_id` int(11) DEFAULT NULL,
  `field_type_id` int(11) DEFAULT NULL,
  `field_index` text,
  PRIMARY KEY (`area_field_id`),
  KEY `FK_area_field_area_type` (`area_type_id`),
  KEY `FK_area_field_field_type` (`field_type_id`),
  CONSTRAINT `FK_area_field_area_type` FOREIGN KEY (`area_type_id`) REFERENCES `area_type` (`area_type_id`),
  CONSTRAINT `FK_area_field_field_type` FOREIGN KEY (`field_type_id`) REFERENCES `field_type` (`field_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы conjuncture.area_field: ~200 rows (приблизительно)
DELETE FROM `area_field`;
/*!40000 ALTER TABLE `area_field` DISABLE KEYS */;
INSERT INTO `area_field` (`area_field_id`, `area_type_id`, `field_type_id`, `field_index`) VALUES
	(1, 1, 1, '00'),
	(2, 1, 1, '01'),
	(3, 1, 1, '02'),
	(4, 1, 1, '03'),
	(5, 1, 1, '04'),
	(6, 1, 1, '05'),
	(7, 1, 1, '10'),
	(8, 1, 2, '11'),
	(9, 1, 2, '12'),
	(10, 1, 2, '13'),
	(11, 1, 2, '14'),
	(12, 1, 1, '15'),
	(13, 1, 1, '20'),
	(14, 1, 2, '21'),
	(15, 1, 3, '22'),
	(16, 1, 3, '23'),
	(17, 1, 2, '24'),
	(18, 1, 1, '25'),
	(19, 1, 1, '30'),
	(20, 1, 2, '31'),
	(21, 1, 3, '32'),
	(22, 1, 3, '33'),
	(23, 1, 2, '34'),
	(24, 1, 1, '35'),
	(25, 1, 1, '40'),
	(26, 1, 2, '41'),
	(27, 1, 2, '42'),
	(28, 1, 2, '43'),
	(29, 1, 2, '44'),
	(30, 1, 1, '45'),
	(31, 1, 1, '50'),
	(32, 1, 1, '51'),
	(33, 1, 1, '52'),
	(34, 1, 1, '53'),
	(35, 1, 1, '54'),
	(36, 1, 1, '55'),
	(37, 2, 1, '00'),
	(38, 2, 1, '01'),
	(39, 2, 1, '02'),
	(40, 2, 1, '03'),
	(41, 2, 1, '04'),
	(42, 2, 1, '05'),
	(43, 2, 1, '06'),
	(44, 2, 1, '07'),
	(45, 2, 1, '10'),
	(46, 2, 2, '11'),
	(47, 2, 2, '12'),
	(48, 2, 2, '13'),
	(49, 2, 2, '14'),
	(50, 2, 2, '15'),
	(51, 2, 2, '16'),
	(52, 2, 1, '17'),
	(53, 2, 1, '20'),
	(54, 2, 2, '21'),
	(55, 2, 3, '22'),
	(56, 2, 3, '23'),
	(57, 2, 3, '24'),
	(58, 2, 3, '25'),
	(59, 2, 2, '26'),
	(60, 2, 1, '27'),
	(61, 2, 1, '30'),
	(62, 2, 2, '31'),
	(63, 2, 3, '32'),
	(64, 2, 4, '33'),
	(65, 2, 4, '34'),
	(66, 2, 3, '35'),
	(67, 2, 2, '36'),
	(68, 2, 1, '37'),
	(69, 2, 1, '40'),
	(70, 2, 2, '41'),
	(71, 2, 3, '42'),
	(72, 2, 4, '43'),
	(73, 2, 4, '44'),
	(74, 2, 3, '45'),
	(75, 2, 2, '46'),
	(76, 2, 1, '47'),
	(77, 2, 1, '50'),
	(78, 2, 2, '51'),
	(79, 2, 3, '52'),
	(80, 2, 3, '53'),
	(81, 2, 3, '54'),
	(82, 2, 3, '55'),
	(83, 2, 2, '56'),
	(84, 2, 1, '57'),
	(85, 2, 1, '60'),
	(86, 2, 2, '61'),
	(87, 2, 2, '62'),
	(88, 2, 2, '63'),
	(89, 2, 2, '64'),
	(90, 2, 2, '65'),
	(91, 2, 2, '66'),
	(92, 2, 1, '67'),
	(93, 2, 1, '70'),
	(94, 2, 1, '71'),
	(95, 2, 1, '72'),
	(96, 2, 1, '73'),
	(97, 2, 1, '74'),
	(98, 2, 1, '75'),
	(99, 2, 1, '76'),
	(100, 2, 1, '77'),
	(101, 3, 1, '00'),
	(102, 3, 1, '01'),
	(103, 3, 1, '02'),
	(104, 3, 1, '03'),
	(105, 3, 1, '04'),
	(106, 3, 1, '05'),
	(107, 3, 1, '06'),
	(108, 3, 1, '07'),
	(109, 3, 1, '08'),
	(110, 3, 1, '09'),
	(111, 3, 1, '10'),
	(112, 3, 2, '11'),
	(113, 3, 2, '12'),
	(114, 3, 2, '13'),
	(115, 3, 2, '14'),
	(116, 3, 2, '15'),
	(117, 3, 2, '16'),
	(118, 3, 2, '17'),
	(119, 3, 2, '18'),
	(120, 3, 1, '19'),
	(121, 3, 1, '20'),
	(122, 3, 2, '21'),
	(123, 3, 3, '22'),
	(124, 3, 3, '23'),
	(125, 3, 3, '24'),
	(126, 3, 3, '25'),
	(127, 3, 3, '26'),
	(128, 3, 3, '27'),
	(129, 3, 2, '28'),
	(130, 3, 1, '29'),
	(131, 3, 1, '30'),
	(132, 3, 2, '31'),
	(133, 3, 3, '32'),
	(134, 3, 4, '33'),
	(135, 3, 4, '34'),
	(136, 3, 4, '35'),
	(137, 3, 4, '36'),
	(138, 3, 3, '37'),
	(139, 3, 2, '38'),
	(140, 3, 1, '39'),
	(141, 3, 1, '40'),
	(142, 3, 2, '41'),
	(143, 3, 3, '42'),
	(144, 3, 4, '43'),
	(145, 3, 5, '44'),
	(146, 3, 5, '45'),
	(147, 3, 4, '46'),
	(148, 3, 3, '47'),
	(149, 3, 2, '48'),
	(150, 3, 1, '49'),
	(151, 3, 1, '50'),
	(152, 3, 2, '51'),
	(153, 3, 3, '52'),
	(154, 3, 4, '53'),
	(155, 3, 5, '54'),
	(156, 3, 5, '55'),
	(157, 3, 4, '56'),
	(158, 3, 3, '57'),
	(159, 3, 2, '58'),
	(160, 3, 1, '59'),
	(161, 3, 1, '60'),
	(162, 3, 2, '61'),
	(163, 3, 3, '62'),
	(164, 3, 4, '63'),
	(165, 3, 4, '64'),
	(166, 3, 4, '65'),
	(167, 3, 4, '66'),
	(168, 3, 3, '67'),
	(169, 3, 2, '68'),
	(170, 3, 1, '69'),
	(171, 3, 1, '70'),
	(172, 3, 2, '71'),
	(173, 3, 3, '72'),
	(174, 3, 3, '73'),
	(175, 3, 3, '74'),
	(176, 3, 3, '75'),
	(177, 3, 3, '76'),
	(178, 3, 3, '77'),
	(179, 3, 2, '78'),
	(180, 3, 1, '79'),
	(181, 3, 1, '80'),
	(182, 3, 2, '81'),
	(183, 3, 2, '82'),
	(184, 3, 2, '83'),
	(185, 3, 2, '84'),
	(186, 3, 2, '85'),
	(187, 3, 2, '86'),
	(188, 3, 2, '87'),
	(189, 3, 2, '88'),
	(190, 3, 1, '89'),
	(191, 3, 1, '90'),
	(192, 3, 1, '91'),
	(193, 3, 1, '92'),
	(194, 3, 1, '93'),
	(195, 3, 1, '94'),
	(196, 3, 1, '95'),
	(197, 3, 1, '96'),
	(198, 3, 1, '97'),
	(199, 3, 1, '98'),
	(200, 3, 1, '99');
/*!40000 ALTER TABLE `area_field` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.area_type
CREATE TABLE IF NOT EXISTS `area_type` (
  `area_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_size` int(11) DEFAULT NULL,
  PRIMARY KEY (`area_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы conjuncture.area_type: ~3 rows (приблизительно)
DELETE FROM `area_type`;
/*!40000 ALTER TABLE `area_type` DISABLE KEYS */;
INSERT INTO `area_type` (`area_type_id`, `area_size`) VALUES
	(1, 6),
	(2, 8),
	(3, 10);
/*!40000 ALTER TABLE `area_type` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.field_type
CREATE TABLE IF NOT EXISTS `field_type` (
  `field_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `field_price` decimal(10,2) DEFAULT NULL,
  `field_value` decimal(10,2) DEFAULT NULL,
  `filed_color` varchar(20) DEFAULT NULL,
  `field_icon` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`field_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.field_type: ~6 rows (приблизительно)
DELETE FROM `field_type`;
/*!40000 ALTER TABLE `field_type` DISABLE KEYS */;
INSERT INTO `field_type` (`field_type_id`, `field_price`, `field_value`, `filed_color`, `field_icon`) VALUES
	(1, 100.00, 2.00, 'BLUE', NULL),
	(2, 200.00, 3.00, 'MAGENTA', NULL),
	(3, 300.00, 4.00, 'GREEN', NULL),
	(4, 400.00, 5.00, 'YELLOW', NULL),
	(5, 500.00, 6.00, 'RED', NULL),
	(6, 600.00, 7.00, 'PINK', NULL);
/*!40000 ALTER TABLE `field_type` ENABLE KEYS */;


-- Дамп структуры для функция conjuncture.f_current_game_by_user
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_current_game_by_user`(`eUserLog` varchar(50)) RETURNS int(11)
begin

return(
select max(g.game_id)
from game g
join game_player gp on gp.game_id=g.game_id
join player p on p.player_id=gp.player_id
where g.date_till is null
and gp.is_active=1
and p.player_log=eUserLog
);

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_gameisover
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_gameisover`(eGameId int) RETURNS int(11)
begin
declare i_date_till datetime;
declare i_gameisover int;

select g.date_till into i_date_till
from game g
where g.game_id=eGameId;

if (i_date_till is null) then
set i_gameisover = 0;
else
set i_gameisover = 1;
end if;

return i_gameisover;
end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_game_create
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_game_create`(`eUser` varchar(20), `eSize` int, `ePassiv` INT, `eSingleGame` INT, `eMaxStepTime` INT) RETURNS int(11)
begin

declare i_player_id int;
declare i_game_id int;
declare i_date_from datetime;
declare i_area_type_id int;

select pl.player_id into i_player_id
from player pl
where pl.player_log=eUser;

select sysdate() into i_date_from;

select aty.area_type_id into i_area_type_id
from area_type aty
where aty.area_size=eSize;

insert into game(date_from,date_till,create_player_id,area_type_id,is_single_game,max_step_time)
values (i_date_from,null,i_player_id,i_area_type_id,eSingleGame,eMaxStepTime);

SELECT LAST_INSERT_ID() into i_game_id;

call p_game_field_insert(i_game_id);
call p_game_player_insert(i_game_id,ePassiv,eUser);

call p_game_activity_update(i_game_id);
call p_player_activity_update(eUser);

if (eSingleGame = 1) then
	call p_game_player_insert(i_game_id,5000,'ADMIN');
	update game_player gp
	set gp.start_steping=gp.start_steping + interval 1 second
	where gp.game_player_id = f_get_game_player_id(i_game_id,'ADMIN');
	
	call p_switch_game_player(i_game_id);
end if;


return i_game_id;

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_game_insert
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_game_insert`(`eUser` varchar(20), `eAreaTypeId` INT) RETURNS int(11)
begin
declare i_player_id int;
declare i_game_id int;
declare i_date_from datetime;

select pl.player_id into i_player_id
from player pl
where pl.player_log='SemenovNA';

select sysdate() into i_date_from;

insert into game(date_from,date_till,create_player_id,area_type_id)
values (i_date_from,null,i_player_id,eAreaTypeId);

SELECT LAST_INSERT_ID() into i_game_id;

return i_game_id;

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_generate_trand_value
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_generate_trand_value`() RETURNS int(11)
begin
declare i_pos_trand_value int;
declare i_neg_trand_value int;
declare i_res_trand_value int;

select 1+round(rand()*5) into i_pos_trand_value;
select -round(rand()*5) into i_neg_trand_value;

set i_res_trand_value = i_pos_trand_value + i_neg_trand_value;

return i_res_trand_value;

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_get_current_balance
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_get_current_balance`(`eGame` INT, `ePlayerLog` VARCHAR(20)) RETURNS decimal(10,2)
begin
return (
select gp.current_passiv_value
from game_player gp
join player p on p.player_id=gp.player_id
where gp.game_id=eGame
and p.player_log=ePlayerLog
);
end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_get_current_user_balance
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_get_current_user_balance`(eGameId int,ePlayerLog varchar(20)) RETURNS decimal(10,2)
begin
declare i_current_balance_val decimal(10,2);

select gp.current_passiv_value into i_current_balance_val
from game_player gp
join player p on p.player_id=gp.player_id
where gp.game_id=eGameId
and p.player_log=ePlayerLog;

return i_current_balance_val;
end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_get_field_value
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_get_field_value`(eGameId int, eFieldIndex varchar(5)) RETURNS decimal(10,2)
begin
declare i_field_value decimal(10,2);

select ft.field_value into i_field_value
from game_field gf
join field_type ft on ft.field_type_id=gf.field_type_id
where gf.game_id=eGameId
and gf.field_index=eFieldIndex;

return i_field_value;

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_get_game_field_owner
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_get_game_field_owner`(eGameId int,ePlayerLog varchar(20),eFieldIndex varchar(5)) RETURNS varchar(20) CHARSET utf8
begin
declare i_field_owner varchar(20);
declare i_owner_sym varchar(20);

select p.player_log into i_field_owner
from game_field gf
left join game_player gp on gp.game_player_id=gf.game_player_id
left join player p on p.player_id=gp.player_id
where gf.game_id=eGameId
and gf.field_index=eFieldIndex;

if (i_field_owner = ePlayerLog) then
set i_owner_sym = 'ME';
elseif (i_field_owner is null) then
set i_owner_sym = 'NOBODY';
else
set i_owner_sym = 'OTHER';
end if;

return i_owner_sym;
end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_get_game_player_id
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_get_game_player_id`(eGameId int,ePlayerLog varchar(20)) RETURNS int(11)
begin
declare i_game_player_id int;

select gp.game_player_id into i_game_player_id
from game_player gp
join player p on p.player_id=gp.player_id
where gp.game_id = eGameId
and p.player_log = ePlayerLog;
 
return i_game_player_id;

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_get_game_size
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_get_game_size`(eGameId int) RETURNS int(11)
begin

return (
select at.area_size
from game g
join area_type at on at.area_type_id = g.area_type_id
where g.game_id = eGameId
);

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_get_invite_game
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_get_invite_game`(eInviteId int) RETURNS varchar(50) CHARSET utf8
begin

return(
select inv.game_id
from invites inv
where inv.invite_id=eInviteId
);

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_get_invite_status
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_get_invite_status`(eInviteId int) RETURNS varchar(50) CHARSET utf8
begin

return(
select inv.status_value
from invites inv
where inv.invite_id=eInviteId
);

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_get_steping_time
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_get_steping_time`(`eGameId` int, `eUserLog` varchar(50)) RETURNS char(5) CHARSET utf8
begin
return(
select if (timestampdiff(second,gp.start_steping,sysdate())<3599,
cast(time_format(sec_to_time(ifnull(timestampdiff(second,gp.start_steping,sysdate()),'0')),'%i:%s') as char)
,'59:59'
)
from game_player gp
join player p on p.player_id=gp.player_id
join game g on g.game_id=gp.game_id
where g.game_id = eGameId
and p.player_log = eUserLog
);
end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_get_steping_user_name
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_get_steping_user_name`(eGameId int) RETURNS varchar(20) CHARSET utf8
begin
return (
select p.player_log
from game_player gp
join player p on p.player_id=gp.player_id
where gp.game_id=eGameId
and gp.is_steping=1
);
end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_ins_test_game_player
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_ins_test_game_player`() RETURNS int(11)
begin
declare i_max_game_id int;
declare i_now_datetime datetime;

select max(g.game_id) into i_max_game_id
from game g;

select now() into i_now_datetime;

insert into game_player(game_id
,player_id
,in_time
,in_passiv_value
,current_passiv_value
,player_sym
,order_connect
,is_steping
)
values (i_max_game_id
,2
,i_now_datetime
,1000
,1000
,'G'
,2
,0
);

update game_player gp
set gp.is_steping = 1
where gp.game_id = i_max_game_id
and gp.player_id != 2;

return 1;

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_is_player_lost
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_is_player_lost`(`eGameId` int, `eUserLog` varchar(50)) RETURNS int(11)
begin

declare i_current_passiv_value int;

select ifnull(gp.current_passiv_value,0) into i_current_passiv_value
from game_player gp
join player p on p.player_id=gp.player_id
where gp.game_id = eGameId
and p.player_log = eUserLog;

if (i_current_passiv_value <= 0) then
return 1;
else
return 0;
end if;

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_is_player_won
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_is_player_won`(eGameId int, eUserLog varchar(50)) RETURNS int(11)
begin

declare i_cnt_active_players int;
declare i_cnt_players int;
declare is_player_active int;

select (
select count(*)
from game_player gp
where gp.game_id=g.game_id
) cnt
,(
select count(*)
from game_player gp
where gp.game_id=g.game_id
and gp.is_active=1
) cnt_active
into i_cnt_players
,i_cnt_active_players
from game g
where g.game_id = eGameId;

select gp.is_active into is_player_active
from game_player gp
join player p on p.player_id=gp.player_id
where gp.game_id = eGameId
and p.player_log = eUserLog;

if (i_cnt_active_players = 1) 
and (i_cnt_players > 1)
and (is_player_active = 1) then
return 1;
else
return 0;
end if;

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_is_possible_to_buy
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_is_possible_to_buy`(eGameId int,ePlayerLog varchar(20),eIndexVal varchar(5)) RETURNS tinyint(1)
begin
return(
select cast(if(gp.current_passiv_value<fty.field_price,false,true) as BINARY)
from game_player gp
join player p on p.player_id=gp.player_id
join game_field gf on gf.game_id=gp.game_id and gf.field_index=eIndexVal
join field_type fty on fty.field_type_id=gf.field_type_id
where gp.game_id=eGameId
and p.player_log=ePlayerLog
);
end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_is_user_engaged
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_is_user_engaged`(`eGameId` int, `eGamePlayerId` INT, `eFieldIndex` varchar(20)) RETURNS int(11)
begin
declare i_cnt_fields int;

select count(*) into i_cnt_fields
from game_field gf
where gf.game_id=eGameId
and gf.field_index=eFieldIndex
and gf.game_player_id=eGamePlayerId;

return i_cnt_fields;

end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_is_user_engaging_field
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_is_user_engaging_field`(`eGameFields` text, `eEngagingIndex` varchar(5)) RETURNS int(11)
begin
declare i_value_count int;
declare i_value_index varchar(5);
declare i int default 1;
declare s int default 0;

set i_value_count:=extractvalue(eGameFields, 'count(/list/string)');

if (i_value_count > 0) then

while (i<=i_value_count) do

set i_value_index = extractvalue(eGameFields, '/list/string[$i]');

if (i_value_index = eEngagingIndex) then
set s = s+1;
end if;

set i=i+1;
end while;

end if;

return s;
end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_is_user_exists
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_is_user_exists`(`eUserLog` varchar(20), `ePassWord` varchar(20)) RETURNS int(11)
begin
declare i_cnt_players int;
declare i_is_exists int;

select count(*) into i_cnt_players
from player p
where p.player_log = eUserLog
and p.player_pass = ePassWord;

if (i_cnt_players > 0) then
set i_is_exists = 1;
call p_player_activity_update(eUserLog);
else
set i_is_exists = 0;
end if;

return i_is_exists;
end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_itsmyturn
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_itsmyturn`(eGameId int,ePlayerLog varchar(20)) RETURNS int(11)
begin
declare i_game_player_id int;
declare i_is_steping int;

select f_get_game_player_id(eGameId, ePlayerLog) into i_game_player_id;

select gp.is_steping into i_is_steping
from game_player gp
where gp.game_id = eGameId
and gp.game_player_id = i_game_player_id;

return i_is_steping;
end//
DELIMITER ;


-- Дамп структуры для функция conjuncture.f_user_ava_change
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_user_ava_change`(`eUserLog` varchar(50)) RETURNS varchar(200) CHARSET utf8
begin

declare i_file_name VARCHAR(200);

select CONCAT(CONCAT(CONCAT(p.player_log,'_'),trim(CONVERT(p.uploadnum+1, CHAR(50)))),'.png')
into i_file_name
from player p
where p.player_log=eUserLog;

update player p
set p.player_ava=i_file_name
,p.uploadnum=p.uploadnum+1
where p.player_log=eUserLog;

return i_file_name;

end//
DELIMITER ;


-- Дамп структуры для таблица conjuncture.game
CREATE TABLE IF NOT EXISTS `game` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_from` datetime NOT NULL,
  `date_till` datetime DEFAULT NULL,
  `create_player_id` int(11) NOT NULL,
  `area_type_id` int(11) NOT NULL,
  `is_single_game` int(11) DEFAULT NULL,
  `last_activity` datetime DEFAULT NULL,
  `max_step_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.game: ~16 rows (приблизительно)
DELETE FROM `game`;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` (`game_id`, `date_from`, `date_till`, `create_player_id`, `area_type_id`, `is_single_game`, `last_activity`, `max_step_time`) VALUES
	(1, '2017-05-08 21:41:32', NULL, 3, 1, 1, '2017-05-08 21:49:41', 60),
	(4, '2017-05-08 21:55:53', NULL, 3, 1, 1, '2017-05-08 22:07:26', 60),
	(5, '2017-05-08 22:06:34', NULL, 3, 1, 1, '2017-05-08 22:06:34', 60),
	(6, '2017-05-08 22:07:03', NULL, 3, 1, 1, '2017-05-08 22:07:03', 60),
	(7, '2017-05-08 22:07:25', NULL, 3, 1, 1, '2017-05-08 22:07:25', 60),
	(8, '2017-05-08 22:29:33', NULL, 3, 1, 1, '2017-05-08 22:42:15', 60),
	(9, '2017-05-08 22:38:29', NULL, 3, 1, 1, '2017-05-08 23:29:30', 60),
	(10, '2017-05-08 22:38:40', NULL, 3, 1, 1, '2017-05-08 23:04:10', 60),
	(11, '2017-05-08 22:42:14', NULL, 3, 1, 1, '2017-05-08 22:46:27', 60),
	(12, '2017-05-08 22:46:26', NULL, 3, 1, 1, '2017-05-08 22:54:18', 60),
	(13, '2017-05-08 22:54:18', NULL, 3, 1, 1, '2017-05-08 23:00:18', 60),
	(14, '2017-05-08 23:04:10', NULL, 3, 1, 1, '2017-05-08 23:09:33', 60),
	(15, '2017-05-08 23:35:08', NULL, 3, 1, 1, '2017-05-08 23:35:32', 60),
	(16, '2017-05-08 23:36:03', NULL, 3, 1, 1, '2017-05-08 23:36:25', 60),
	(17, '2017-05-08 23:38:17', NULL, 3, 1, 1, '2017-05-08 23:41:37', 60),
	(18, '2017-05-08 23:41:48', NULL, 3, 1, 1, '2017-05-09 00:04:18', 60),
	(19, '2017-05-09 00:04:30', NULL, 3, 1, 1, '2017-05-09 00:05:38', 60);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.game_field
CREATE TABLE IF NOT EXISTS `game_field` (
  `game_field_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) DEFAULT NULL,
  `field_value` decimal(10,2) DEFAULT NULL,
  `field_index` varchar(5) DEFAULT NULL,
  `field_type_id` int(11) DEFAULT NULL,
  `game_player_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`game_field_id`),
  KEY `FK_game_field_game` (`game_id`),
  KEY `FK_game_field_field_type` (`field_type_id`),
  KEY `FK_game_field_game_player` (`game_player_id`),
  CONSTRAINT `FK_game_field_field_type` FOREIGN KEY (`field_type_id`) REFERENCES `field_type` (`field_type_id`),
  CONSTRAINT `FK_game_field_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FK_game_field_game_player` FOREIGN KEY (`game_player_id`) REFERENCES `game_player` (`game_player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=757 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.game_field: ~409 rows (приблизительно)
DELETE FROM `game_field`;
/*!40000 ALTER TABLE `game_field` DISABLE KEYS */;
INSERT INTO `game_field` (`game_field_id`, `game_id`, `field_value`, `field_index`, `field_type_id`, `game_player_id`) VALUES
	(1, 8, 2.00, '00', 1, NULL),
	(2, 8, 2.00, '01', 1, NULL),
	(3, 8, 2.00, '02', 1, NULL),
	(4, 8, 2.00, '03', 1, 2),
	(5, 8, 2.00, '04', 1, NULL),
	(6, 8, 2.00, '05', 1, NULL),
	(7, 8, 2.00, '10', 1, NULL),
	(8, 8, 2.00, '15', 1, NULL),
	(9, 8, 2.00, '20', 1, NULL),
	(10, 8, 2.00, '25', 1, NULL),
	(11, 8, 2.00, '30', 1, NULL),
	(12, 8, 2.00, '35', 1, NULL),
	(13, 8, 2.00, '40', 1, NULL),
	(14, 8, 2.00, '45', 1, NULL),
	(15, 8, 2.00, '50', 1, NULL),
	(16, 8, 2.00, '51', 1, NULL),
	(17, 8, 2.00, '52', 1, NULL),
	(18, 8, 2.00, '53', 1, NULL),
	(19, 8, 2.00, '54', 1, NULL),
	(20, 8, 2.00, '55', 1, NULL),
	(21, 8, 3.00, '11', 2, NULL),
	(22, 8, 3.00, '12', 2, NULL),
	(23, 8, 3.00, '13', 2, NULL),
	(24, 8, 3.00, '14', 2, NULL),
	(25, 8, 3.00, '21', 2, NULL),
	(26, 8, 3.00, '24', 2, NULL),
	(27, 8, 3.00, '31', 2, NULL),
	(28, 8, 3.00, '34', 2, NULL),
	(29, 8, 3.00, '41', 2, NULL),
	(30, 8, 3.00, '42', 2, NULL),
	(31, 8, 3.00, '43', 2, NULL),
	(32, 8, 3.00, '44', 2, NULL),
	(33, 8, 4.00, '22', 3, NULL),
	(34, 8, 4.00, '23', 3, NULL),
	(35, 8, 4.00, '32', 3, NULL),
	(36, 8, 4.00, '33', 3, NULL),
	(64, 9, 2.00, '00', 1, NULL),
	(65, 9, 2.00, '01', 1, NULL),
	(66, 9, 2.00, '02', 1, NULL),
	(67, 9, 2.00, '03', 1, NULL),
	(68, 9, 2.00, '04', 1, NULL),
	(69, 9, 2.00, '05', 1, NULL),
	(70, 9, 2.00, '10', 1, NULL),
	(71, 9, 2.00, '15', 1, NULL),
	(72, 9, 2.00, '20', 1, NULL),
	(73, 9, 2.00, '25', 1, NULL),
	(74, 9, 2.00, '30', 1, NULL),
	(75, 9, 2.00, '35', 1, NULL),
	(76, 9, 2.00, '40', 1, NULL),
	(77, 9, 2.00, '45', 1, NULL),
	(78, 9, 2.00, '50', 1, NULL),
	(79, 9, 2.00, '51', 1, NULL),
	(80, 9, 2.00, '52', 1, NULL),
	(81, 9, 2.00, '53', 1, NULL),
	(82, 9, 2.00, '54', 1, NULL),
	(83, 9, 2.00, '55', 1, NULL),
	(84, 9, 3.00, '11', 2, NULL),
	(85, 9, 3.00, '12', 2, NULL),
	(86, 9, 3.00, '13', 2, NULL),
	(87, 9, 3.00, '14', 2, NULL),
	(88, 9, 3.00, '21', 2, NULL),
	(89, 9, 3.00, '24', 2, NULL),
	(90, 9, 3.00, '31', 2, NULL),
	(91, 9, 3.00, '34', 2, NULL),
	(92, 9, 3.00, '41', 2, NULL),
	(93, 9, 3.00, '42', 2, NULL),
	(94, 9, 3.00, '43', 2, NULL),
	(95, 9, 3.00, '44', 2, NULL),
	(96, 9, 4.00, '22', 3, NULL),
	(97, 9, 4.00, '23', 3, NULL),
	(98, 9, 4.00, '32', 3, NULL),
	(99, 9, 4.00, '33', 3, NULL),
	(127, 10, 2.00, '00', 1, NULL),
	(128, 10, 2.00, '01', 1, NULL),
	(129, 10, 2.00, '02', 1, NULL),
	(130, 10, 2.00, '03', 1, NULL),
	(131, 10, 2.00, '04', 1, NULL),
	(132, 10, 2.00, '05', 1, NULL),
	(133, 10, 2.00, '10', 1, NULL),
	(134, 10, 2.00, '15', 1, NULL),
	(135, 10, 2.00, '20', 1, NULL),
	(136, 10, 2.00, '25', 1, NULL),
	(137, 10, 2.00, '30', 1, NULL),
	(138, 10, 2.00, '35', 1, NULL),
	(139, 10, 2.00, '40', 1, NULL),
	(140, 10, 2.00, '45', 1, NULL),
	(141, 10, 2.00, '50', 1, NULL),
	(142, 10, 2.00, '51', 1, NULL),
	(143, 10, 2.00, '52', 1, NULL),
	(144, 10, 2.00, '53', 1, NULL),
	(145, 10, 2.00, '54', 1, NULL),
	(146, 10, 2.00, '55', 1, NULL),
	(147, 10, 3.00, '11', 2, NULL),
	(148, 10, 3.00, '12', 2, NULL),
	(149, 10, 3.00, '13', 2, NULL),
	(150, 10, 3.00, '14', 2, NULL),
	(151, 10, 3.00, '21', 2, NULL),
	(152, 10, 3.00, '24', 2, NULL),
	(153, 10, 3.00, '31', 2, NULL),
	(154, 10, 3.00, '34', 2, NULL),
	(155, 10, 3.00, '41', 2, NULL),
	(156, 10, 3.00, '42', 2, NULL),
	(157, 10, 3.00, '43', 2, NULL),
	(158, 10, 3.00, '44', 2, NULL),
	(159, 10, 4.00, '22', 3, NULL),
	(160, 10, 4.00, '23', 3, NULL),
	(161, 10, 4.00, '32', 3, NULL),
	(162, 10, 4.00, '33', 3, NULL),
	(190, 11, 2.00, '00', 1, NULL),
	(191, 11, 2.00, '01', 1, NULL),
	(192, 11, 2.00, '02', 1, NULL),
	(193, 11, 2.00, '03', 1, NULL),
	(194, 11, 2.00, '04', 1, NULL),
	(195, 11, 2.00, '05', 1, NULL),
	(196, 11, 2.00, '10', 1, NULL),
	(197, 11, 2.00, '15', 1, NULL),
	(198, 11, 2.00, '20', 1, NULL),
	(199, 11, 2.00, '25', 1, NULL),
	(200, 11, 2.00, '30', 1, NULL),
	(201, 11, 2.00, '35', 1, NULL),
	(202, 11, 2.00, '40', 1, NULL),
	(203, 11, 2.00, '45', 1, NULL),
	(204, 11, 2.00, '50', 1, NULL),
	(205, 11, 2.00, '51', 1, NULL),
	(206, 11, 2.00, '52', 1, NULL),
	(207, 11, 2.00, '53', 1, NULL),
	(208, 11, 2.00, '54', 1, NULL),
	(209, 11, 2.00, '55', 1, NULL),
	(210, 11, 3.00, '11', 2, NULL),
	(211, 11, 3.00, '12', 2, NULL),
	(212, 11, 3.00, '13', 2, NULL),
	(213, 11, 3.00, '14', 2, NULL),
	(214, 11, 3.00, '21', 2, NULL),
	(215, 11, 3.00, '24', 2, NULL),
	(216, 11, 3.00, '31', 2, NULL),
	(217, 11, 3.00, '34', 2, NULL),
	(218, 11, 3.00, '41', 2, NULL),
	(219, 11, 3.00, '42', 2, NULL),
	(220, 11, 3.00, '43', 2, NULL),
	(221, 11, 3.00, '44', 2, NULL),
	(222, 11, 4.00, '22', 3, NULL),
	(223, 11, 4.00, '23', 3, NULL),
	(224, 11, 4.00, '32', 3, NULL),
	(225, 11, 4.00, '33', 3, NULL),
	(253, 12, 2.00, '00', 1, NULL),
	(254, 12, 2.00, '01', 1, NULL),
	(255, 12, 2.00, '02', 1, NULL),
	(256, 12, 2.00, '03', 1, NULL),
	(257, 12, 2.00, '04', 1, NULL),
	(258, 12, 2.00, '05', 1, NULL),
	(259, 12, 2.00, '10', 1, NULL),
	(260, 12, 2.00, '15', 1, NULL),
	(261, 12, 2.00, '20', 1, NULL),
	(262, 12, 2.00, '25', 1, NULL),
	(263, 12, 2.00, '30', 1, NULL),
	(264, 12, 2.00, '35', 1, NULL),
	(265, 12, 2.00, '40', 1, NULL),
	(266, 12, 2.00, '45', 1, NULL),
	(267, 12, 2.00, '50', 1, NULL),
	(268, 12, 2.00, '51', 1, NULL),
	(269, 12, 2.00, '52', 1, NULL),
	(270, 12, 2.00, '53', 1, NULL),
	(271, 12, 2.00, '54', 1, NULL),
	(272, 12, 2.00, '55', 1, NULL),
	(273, 12, 3.00, '11', 2, NULL),
	(274, 12, 3.00, '12', 2, NULL),
	(275, 12, 3.00, '13', 2, NULL),
	(276, 12, 3.00, '14', 2, NULL),
	(277, 12, 3.00, '21', 2, NULL),
	(278, 12, 3.00, '24', 2, NULL),
	(279, 12, 3.00, '31', 2, NULL),
	(280, 12, 3.00, '34', 2, NULL),
	(281, 12, 3.00, '41', 2, NULL),
	(282, 12, 3.00, '42', 2, NULL),
	(283, 12, 3.00, '43', 2, NULL),
	(284, 12, 3.00, '44', 2, NULL),
	(285, 12, 4.00, '22', 3, NULL),
	(286, 12, 4.00, '23', 3, NULL),
	(287, 12, 4.00, '32', 3, NULL),
	(288, 12, 4.00, '33', 3, NULL),
	(316, 13, 2.00, '00', 1, NULL),
	(317, 13, 2.00, '01', 1, NULL),
	(318, 13, 2.00, '02', 1, NULL),
	(319, 13, 2.00, '03', 1, NULL),
	(320, 13, 2.00, '04', 1, NULL),
	(321, 13, 2.00, '05', 1, NULL),
	(322, 13, 2.00, '10', 1, NULL),
	(323, 13, 2.00, '15', 1, NULL),
	(324, 13, 2.00, '20', 1, NULL),
	(325, 13, 2.00, '25', 1, NULL),
	(326, 13, 2.00, '30', 1, NULL),
	(327, 13, 2.00, '35', 1, NULL),
	(328, 13, 2.00, '40', 1, NULL),
	(329, 13, 2.00, '45', 1, NULL),
	(330, 13, 2.00, '50', 1, NULL),
	(331, 13, 2.00, '51', 1, NULL),
	(332, 13, 2.00, '52', 1, NULL),
	(333, 13, 2.00, '53', 1, NULL),
	(334, 13, 2.00, '54', 1, NULL),
	(335, 13, 2.00, '55', 1, NULL),
	(336, 13, 3.00, '11', 2, NULL),
	(337, 13, 3.00, '12', 2, NULL),
	(338, 13, 3.00, '13', 2, NULL),
	(339, 13, 3.00, '14', 2, NULL),
	(340, 13, 3.00, '21', 2, NULL),
	(341, 13, 3.00, '24', 2, NULL),
	(342, 13, 3.00, '31', 2, NULL),
	(343, 13, 3.00, '34', 2, NULL),
	(344, 13, 3.00, '41', 2, NULL),
	(345, 13, 3.00, '42', 2, NULL),
	(346, 13, 3.00, '43', 2, NULL),
	(347, 13, 3.00, '44', 2, NULL),
	(348, 13, 4.00, '22', 3, NULL),
	(349, 13, 4.00, '23', 3, NULL),
	(350, 13, 4.00, '32', 3, NULL),
	(351, 13, 4.00, '33', 3, NULL),
	(379, 14, 2.00, '00', 1, NULL),
	(380, 14, 2.00, '01', 1, NULL),
	(381, 14, 2.00, '02', 1, NULL),
	(382, 14, 2.00, '03', 1, NULL),
	(383, 14, 2.00, '04', 1, NULL),
	(384, 14, 2.00, '05', 1, NULL),
	(385, 14, 2.00, '10', 1, NULL),
	(386, 14, 2.00, '15', 1, NULL),
	(387, 14, 2.00, '20', 1, NULL),
	(388, 14, 2.00, '25', 1, NULL),
	(389, 14, 2.00, '30', 1, NULL),
	(390, 14, 2.00, '35', 1, NULL),
	(391, 14, 2.00, '40', 1, NULL),
	(392, 14, 2.00, '45', 1, NULL),
	(393, 14, 2.00, '50', 1, NULL),
	(394, 14, 2.00, '51', 1, NULL),
	(395, 14, 2.00, '52', 1, NULL),
	(396, 14, 2.00, '53', 1, NULL),
	(397, 14, 2.00, '54', 1, NULL),
	(398, 14, 2.00, '55', 1, NULL),
	(399, 14, 3.00, '11', 2, NULL),
	(400, 14, 3.00, '12', 2, NULL),
	(401, 14, 3.00, '13', 2, NULL),
	(402, 14, 3.00, '14', 2, NULL),
	(403, 14, 3.00, '21', 2, NULL),
	(404, 14, 3.00, '24', 2, NULL),
	(405, 14, 3.00, '31', 2, NULL),
	(406, 14, 3.00, '34', 2, NULL),
	(407, 14, 3.00, '41', 2, NULL),
	(408, 14, 3.00, '42', 2, NULL),
	(409, 14, 3.00, '43', 2, NULL),
	(410, 14, 3.00, '44', 2, NULL),
	(411, 14, 4.00, '22', 3, NULL),
	(412, 14, 4.00, '23', 3, NULL),
	(413, 14, 4.00, '32', 3, NULL),
	(414, 14, 4.00, '33', 3, NULL),
	(442, 15, 2.00, '00', 1, NULL),
	(443, 15, 2.00, '01', 1, NULL),
	(444, 15, 2.00, '02', 1, NULL),
	(445, 15, 2.00, '03', 1, NULL),
	(446, 15, 2.00, '04', 1, NULL),
	(447, 15, 2.00, '05', 1, NULL),
	(448, 15, 2.00, '10', 1, NULL),
	(449, 15, 2.00, '15', 1, NULL),
	(450, 15, 2.00, '20', 1, NULL),
	(451, 15, 2.00, '25', 1, NULL),
	(452, 15, 2.00, '30', 1, NULL),
	(453, 15, 2.00, '35', 1, NULL),
	(454, 15, 2.00, '40', 1, NULL),
	(455, 15, 2.00, '45', 1, NULL),
	(456, 15, 2.00, '50', 1, NULL),
	(457, 15, 2.00, '51', 1, NULL),
	(458, 15, 2.00, '52', 1, NULL),
	(459, 15, 2.00, '53', 1, NULL),
	(460, 15, 2.00, '54', 1, NULL),
	(461, 15, 2.00, '55', 1, NULL),
	(462, 15, 3.00, '11', 2, NULL),
	(463, 15, 3.00, '12', 2, NULL),
	(464, 15, 3.00, '13', 2, NULL),
	(465, 15, 3.00, '14', 2, NULL),
	(466, 15, 3.00, '21', 2, NULL),
	(467, 15, 3.00, '24', 2, NULL),
	(468, 15, 3.00, '31', 2, NULL),
	(469, 15, 3.00, '34', 2, NULL),
	(470, 15, 3.00, '41', 2, NULL),
	(471, 15, 3.00, '42', 2, NULL),
	(472, 15, 3.00, '43', 2, NULL),
	(473, 15, 3.00, '44', 2, NULL),
	(474, 15, 4.00, '22', 3, NULL),
	(475, 15, 4.00, '23', 3, NULL),
	(476, 15, 4.00, '32', 3, NULL),
	(477, 15, 4.00, '33', 3, NULL),
	(505, 16, 2.00, '00', 1, NULL),
	(506, 16, 2.00, '01', 1, NULL),
	(507, 16, 2.00, '02', 1, NULL),
	(508, 16, 2.00, '03', 1, NULL),
	(509, 16, 2.00, '04', 1, NULL),
	(510, 16, 2.00, '05', 1, NULL),
	(511, 16, 2.00, '10', 1, NULL),
	(512, 16, 2.00, '15', 1, NULL),
	(513, 16, 2.00, '20', 1, NULL),
	(514, 16, 2.00, '25', 1, NULL),
	(515, 16, 2.00, '30', 1, NULL),
	(516, 16, 2.00, '35', 1, NULL),
	(517, 16, 2.00, '40', 1, NULL),
	(518, 16, 2.00, '45', 1, NULL),
	(519, 16, 2.00, '50', 1, NULL),
	(520, 16, 2.00, '51', 1, NULL),
	(521, 16, 2.00, '52', 1, NULL),
	(522, 16, 2.00, '53', 1, NULL),
	(523, 16, 2.00, '54', 1, NULL),
	(524, 16, 2.00, '55', 1, NULL),
	(525, 16, 3.00, '11', 2, NULL),
	(526, 16, 3.00, '12', 2, NULL),
	(527, 16, 3.00, '13', 2, NULL),
	(528, 16, 3.00, '14', 2, NULL),
	(529, 16, 3.00, '21', 2, NULL),
	(530, 16, 3.00, '24', 2, NULL),
	(531, 16, 3.00, '31', 2, NULL),
	(532, 16, 3.00, '34', 2, NULL),
	(533, 16, 3.00, '41', 2, NULL),
	(534, 16, 3.00, '42', 2, NULL),
	(535, 16, 3.00, '43', 2, NULL),
	(536, 16, 3.00, '44', 2, NULL),
	(537, 16, 4.00, '22', 3, NULL),
	(538, 16, 4.00, '23', 3, NULL),
	(539, 16, 4.00, '32', 3, NULL),
	(540, 16, 4.00, '33', 3, NULL),
	(568, 17, 2.00, '00', 1, NULL),
	(569, 17, 2.00, '01', 1, NULL),
	(570, 17, 2.00, '02', 1, NULL),
	(571, 17, 2.00, '03', 1, NULL),
	(572, 17, 2.00, '04', 1, NULL),
	(573, 17, 2.00, '05', 1, NULL),
	(574, 17, 2.00, '10', 1, NULL),
	(575, 17, 2.00, '15', 1, NULL),
	(576, 17, 2.00, '20', 1, NULL),
	(577, 17, 2.00, '25', 1, NULL),
	(578, 17, 2.00, '30', 1, NULL),
	(579, 17, 2.00, '35', 1, NULL),
	(580, 17, 2.00, '40', 1, NULL),
	(581, 17, 2.00, '45', 1, NULL),
	(582, 17, 2.00, '50', 1, NULL),
	(583, 17, 2.00, '51', 1, NULL),
	(584, 17, 2.00, '52', 1, NULL),
	(585, 17, 2.00, '53', 1, NULL),
	(586, 17, 2.00, '54', 1, NULL),
	(587, 17, 2.00, '55', 1, NULL),
	(588, 17, 3.00, '11', 2, NULL),
	(589, 17, 3.00, '12', 2, NULL),
	(590, 17, 3.00, '13', 2, NULL),
	(591, 17, 3.00, '14', 2, NULL),
	(592, 17, 3.00, '21', 2, NULL),
	(593, 17, 3.00, '24', 2, NULL),
	(594, 17, 3.00, '31', 2, NULL),
	(595, 17, 3.00, '34', 2, NULL),
	(596, 17, 3.00, '41', 2, 20),
	(597, 17, 3.00, '42', 2, 20),
	(598, 17, 3.00, '43', 2, NULL),
	(599, 17, 3.00, '44', 2, NULL),
	(600, 17, 4.00, '22', 3, NULL),
	(601, 17, 4.00, '23', 3, 20),
	(602, 17, 4.00, '32', 3, NULL),
	(603, 17, 4.00, '33', 3, NULL),
	(631, 18, 2.00, '00', 1, NULL),
	(632, 18, 2.00, '01', 1, NULL),
	(633, 18, 2.00, '02', 1, NULL),
	(634, 18, 2.00, '03', 1, NULL),
	(635, 18, 2.00, '04', 1, NULL),
	(636, 18, 2.00, '05', 1, NULL),
	(637, 18, 2.00, '10', 1, NULL),
	(638, 18, 2.00, '15', 1, NULL),
	(639, 18, 2.00, '20', 1, NULL),
	(640, 18, 2.00, '25', 1, NULL),
	(641, 18, 2.00, '30', 1, NULL),
	(642, 18, 2.00, '35', 1, 22),
	(643, 18, 2.00, '40', 1, NULL),
	(644, 18, 2.00, '45', 1, NULL),
	(645, 18, 2.00, '50', 1, NULL),
	(646, 18, 2.00, '51', 1, NULL),
	(647, 18, 2.00, '52', 1, NULL),
	(648, 18, 2.00, '53', 1, NULL),
	(649, 18, 2.00, '54', 1, NULL),
	(650, 18, 2.00, '55', 1, NULL),
	(651, 18, 3.00, '11', 2, NULL),
	(652, 18, 3.00, '12', 2, NULL),
	(653, 18, 3.00, '13', 2, NULL),
	(654, 18, 3.00, '14', 2, NULL),
	(655, 18, 3.00, '21', 2, NULL),
	(656, 18, 3.00, '24', 2, NULL),
	(657, 18, 3.00, '31', 2, NULL),
	(658, 18, 3.00, '34', 2, NULL),
	(659, 18, 3.00, '41', 2, NULL),
	(660, 18, 3.00, '42', 2, NULL),
	(661, 18, 3.00, '43', 2, NULL),
	(662, 18, 3.00, '44', 2, NULL),
	(663, 18, 4.00, '22', 3, NULL),
	(664, 18, 4.00, '23', 3, NULL),
	(665, 18, 4.00, '32', 3, NULL),
	(666, 18, 4.00, '33', 3, NULL),
	(694, 19, 2.00, '00', 1, 23),
	(695, 19, 2.00, '01', 1, NULL),
	(696, 19, 2.00, '02', 1, 24),
	(697, 19, 2.00, '03', 1, NULL),
	(698, 19, 2.00, '04', 1, NULL),
	(699, 19, 2.00, '05', 1, 24),
	(700, 19, 2.00, '10', 1, NULL),
	(701, 19, 2.00, '15', 1, NULL),
	(702, 19, 2.00, '20', 1, NULL),
	(703, 19, 2.00, '25', 1, NULL),
	(704, 19, 2.00, '30', 1, NULL),
	(705, 19, 2.00, '35', 1, 24),
	(706, 19, 2.00, '40', 1, 24),
	(707, 19, 2.00, '45', 1, NULL),
	(708, 19, 2.00, '50', 1, NULL),
	(709, 19, 2.00, '51', 1, 24),
	(710, 19, 2.00, '52', 1, 24),
	(711, 19, 2.00, '53', 1, 24),
	(712, 19, 2.00, '54', 1, NULL),
	(713, 19, 2.00, '55', 1, 24),
	(714, 19, 3.00, '11', 2, NULL),
	(715, 19, 3.00, '12', 2, NULL),
	(716, 19, 3.00, '13', 2, 24),
	(717, 19, 3.00, '14', 2, NULL),
	(718, 19, 3.00, '21', 2, NULL),
	(719, 19, 3.00, '24', 2, NULL),
	(720, 19, 3.00, '31', 2, NULL),
	(721, 19, 3.00, '34', 2, NULL),
	(722, 19, 3.00, '41', 2, NULL),
	(723, 19, 3.00, '42', 2, NULL),
	(724, 19, 3.00, '43', 2, NULL),
	(725, 19, 3.00, '44', 2, NULL),
	(726, 19, 4.00, '22', 3, NULL),
	(727, 19, 4.00, '23', 3, 24),
	(728, 19, 4.00, '32', 3, NULL),
	(729, 19, 4.00, '33', 3, 24);
/*!40000 ALTER TABLE `game_field` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.game_log
CREATE TABLE IF NOT EXISTS `game_log` (
  `var_name` text,
  `var_val` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы conjuncture.game_log: ~0 rows (приблизительно)
DELETE FROM `game_log`;
/*!40000 ALTER TABLE `game_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_log` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.game_player
CREATE TABLE IF NOT EXISTS `game_player` (
  `game_player_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) NOT NULL,
  `player_id` int(11) NOT NULL,
  `in_time` datetime DEFAULT NULL,
  `out_time` datetime DEFAULT NULL,
  `in_passiv_value` decimal(10,2) DEFAULT NULL,
  `out_passiv_value` decimal(10,2) DEFAULT NULL,
  `current_passiv_value` decimal(10,2) DEFAULT NULL,
  `player_sym` varchar(5) DEFAULT NULL,
  `order_connect` int(11) DEFAULT NULL,
  `is_steping` int(11) DEFAULT NULL,
  `is_active` int(11) DEFAULT NULL,
  `start_steping` datetime DEFAULT NULL,
  PRIMARY KEY (`game_player_id`),
  KEY `FK_game_player_game` (`game_id`),
  KEY `FK_game_player_player` (`player_id`),
  CONSTRAINT `FK_game_player_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FK_game_player_player` FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.game_player: ~22 rows (приблизительно)
DELETE FROM `game_player`;
/*!40000 ALTER TABLE `game_player` DISABLE KEYS */;
INSERT INTO `game_player` (`game_player_id`, `game_id`, `player_id`, `in_time`, `out_time`, `in_passiv_value`, `out_passiv_value`, `current_passiv_value`, `player_sym`, `order_connect`, `is_steping`, `is_active`, `start_steping`) VALUES
	(1, 8, 3, '2017-05-08 22:29:33', '2017-05-08 22:42:15', 400.00, 0.00, 0.00, 'k1', 1, 0, 0, '2017-05-08 22:30:21'),
	(2, 8, 4, '2017-05-08 22:29:33', NULL, 5000.00, NULL, 5700.00, 'a2', 2, 1, 1, '2017-05-08 22:30:22'),
	(3, 9, 3, '2017-05-08 22:38:29', '2017-05-08 23:29:30', 400.00, 400.00, 0.00, 'k1', 1, 1, 0, '2017-05-08 22:38:29'),
	(4, 9, 4, '2017-05-08 22:38:29', NULL, 5000.00, NULL, 5000.00, 'a2', 2, 0, 1, '2017-05-08 22:38:29'),
	(5, 10, 3, '2017-05-08 22:38:40', '2017-05-08 23:04:10', 400.00, 0.00, 0.00, 'k1', 1, 1, 0, '2017-05-08 22:38:40'),
	(6, 10, 4, '2017-05-08 22:38:40', NULL, 5000.00, NULL, 5000.00, 'a2', 2, 0, 1, '2017-05-08 22:38:40'),
	(7, 11, 3, '2017-05-08 22:42:14', '2017-05-08 22:46:27', 400.00, 0.00, 0.00, 'k1', 1, 1, 0, '2017-05-08 22:42:14'),
	(8, 11, 4, '2017-05-08 22:42:14', NULL, 5000.00, NULL, 5000.00, 'a2', 2, 0, 1, '2017-05-08 22:42:14'),
	(9, 12, 3, '2017-05-08 22:46:26', '2017-05-08 22:54:18', 4000.00, 0.00, 0.00, 'k1', 1, 1, 0, '2017-05-08 22:46:26'),
	(10, 12, 4, '2017-05-08 22:46:26', NULL, 5000.00, NULL, 5000.00, 'a2', 2, 0, 1, '2017-05-08 22:46:26'),
	(11, 13, 3, '2017-05-08 22:54:18', '2017-05-08 23:00:18', 566.00, 566.00, 0.00, 'k1', 1, 1, 0, '2017-05-08 22:54:18'),
	(12, 13, 4, '2017-05-08 22:54:18', NULL, 5000.00, NULL, 5000.00, 'a2', 2, 0, 1, '2017-05-08 22:54:18'),
	(13, 14, 3, '2017-05-08 23:04:10', '2017-05-08 23:09:33', 456.00, 456.00, 0.00, 'k1', 1, 1, 0, '2017-05-08 23:04:10'),
	(14, 14, 4, '2017-05-08 23:04:10', NULL, 5000.00, NULL, 5000.00, 'a2', 2, 0, 1, '2017-05-08 23:04:10'),
	(15, 15, 3, '2017-05-08 23:35:08', '2017-05-08 23:35:32', 6787.00, 6787.00, 0.00, 'k1', 1, 1, 0, '2017-05-08 23:35:08'),
	(16, 15, 4, '2017-05-08 23:35:08', NULL, 5000.00, NULL, 5000.00, 'a2', 2, 0, 1, '2017-05-08 23:35:08'),
	(17, 16, 3, '2017-05-08 23:36:03', '2017-05-08 23:36:25', 6787.00, 6787.00, 0.00, 'k1', 1, 1, 0, '2017-05-08 23:36:03'),
	(18, 16, 4, '2017-05-08 23:36:03', NULL, 5000.00, NULL, 5000.00, 'a2', 2, 0, 1, '2017-05-08 23:36:03'),
	(19, 17, 3, '2017-05-08 23:38:17', '2017-05-08 23:41:37', 6787.00, 9887.00, 0.00, 'k1', 1, 0, 0, '2017-05-08 23:39:57'),
	(20, 17, 4, '2017-05-08 23:38:17', NULL, 5000.00, NULL, 3100.00, 'a2', 2, 1, 1, '2017-05-08 23:39:57'),
	(21, 18, 3, '2017-05-08 23:41:48', '2017-05-09 00:04:18', 6787.00, 6787.00, 0.00, 'k1', 1, 0, 0, '2017-05-09 00:04:12'),
	(22, 18, 4, '2017-05-08 23:41:48', NULL, 5000.00, NULL, 4700.00, 'a2', 2, 1, 1, '2017-05-09 00:04:12'),
	(23, 19, 3, '2017-05-09 00:04:30', NULL, 56765.00, NULL, 57065.00, 'k1', 1, 0, 1, '2017-05-09 00:05:38'),
	(24, 19, 4, '2017-05-09 00:04:30', NULL, 5000.00, NULL, 9200.00, 'a2', 2, 1, 1, '2017-05-09 00:05:38');
/*!40000 ALTER TABLE `game_player` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.game_player_step_hist
CREATE TABLE IF NOT EXISTS `game_player_step_hist` (
  `game_player_step_hist_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) DEFAULT NULL,
  `game_player_id` int(11) DEFAULT NULL,
  `game_step_id` int(11) DEFAULT NULL,
  `step_result` decimal(10,2) DEFAULT NULL,
  `step_player_passiv` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`game_player_step_hist_id`),
  KEY `FK_game_player_step_hist_game` (`game_id`),
  KEY `FK_game_player_step_hist_player` (`game_player_id`),
  KEY `FK_game_player_step_hist_game_step` (`game_step_id`),
  CONSTRAINT `FK_game_player_step_hist_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FK_game_player_step_hist_game_player` FOREIGN KEY (`game_player_id`) REFERENCES `game_player` (`game_player_id`),
  CONSTRAINT `FK_game_player_step_hist_game_step` FOREIGN KEY (`game_step_id`) REFERENCES `game_step` (`game_step_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.game_player_step_hist: ~0 rows (приблизительно)
DELETE FROM `game_player_step_hist`;
/*!40000 ALTER TABLE `game_player_step_hist` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_player_step_hist` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.game_rate
CREATE TABLE IF NOT EXISTS `game_rate` (
  `game_rate_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) DEFAULT NULL,
  `game_player_id` int(11) DEFAULT NULL,
  `game_step_id` int(11) DEFAULT NULL,
  `game_field_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`game_rate_id`),
  KEY `FK_game_rate_game` (`game_id`),
  KEY `FK_game_rate_player` (`game_player_id`),
  KEY `FK_game_rate_game_step` (`game_step_id`),
  KEY `FK_game_rate_game_field` (`game_field_id`),
  CONSTRAINT `FK_game_rate_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FK_game_rate_game_field` FOREIGN KEY (`game_field_id`) REFERENCES `game_field` (`game_field_id`),
  CONSTRAINT `FK_game_rate_game_player` FOREIGN KEY (`game_player_id`) REFERENCES `game_player` (`game_player_id`),
  CONSTRAINT `FK_game_rate_game_step` FOREIGN KEY (`game_step_id`) REFERENCES `game_step` (`game_step_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.game_rate: ~0 rows (приблизительно)
DELETE FROM `game_rate`;
/*!40000 ALTER TABLE `game_rate` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_rate` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.game_rate_hist
CREATE TABLE IF NOT EXISTS `game_rate_hist` (
  `game_rate_hist_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) DEFAULT NULL,
  `game_player_id` int(11) DEFAULT NULL,
  `game_step_id` int(11) DEFAULT NULL,
  `field_type_id` int(11) DEFAULT NULL,
  `fields_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`game_rate_hist_id`),
  KEY `FK_game_rate_hist_game` (`game_id`),
  KEY `FK_game_rate_hist_game_player` (`game_player_id`),
  KEY `FK_game_rate_hist_game_step` (`game_step_id`),
  KEY `FK_game_rate_hist_field_type` (`field_type_id`),
  CONSTRAINT `FK_game_rate_hist_field_type` FOREIGN KEY (`field_type_id`) REFERENCES `field_type` (`field_type_id`),
  CONSTRAINT `FK_game_rate_hist_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FK_game_rate_hist_game_player` FOREIGN KEY (`game_player_id`) REFERENCES `game_player` (`game_player_id`),
  CONSTRAINT `FK_game_rate_hist_game_step` FOREIGN KEY (`game_step_id`) REFERENCES `game_step` (`game_step_id`)
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы conjuncture.game_rate_hist: ~41 rows (приблизительно)
DELETE FROM `game_rate_hist`;
/*!40000 ALTER TABLE `game_rate_hist` DISABLE KEYS */;
INSERT INTO `game_rate_hist` (`game_rate_hist_id`, `game_id`, `game_player_id`, `game_step_id`, `field_type_id`, `fields_count`) VALUES
	(1, 8, NULL, 1, 1, 19),
	(2, 8, NULL, 1, 2, 12),
	(3, 8, NULL, 1, 3, 4),
	(4, 8, 1, 1, 1, 1),
	(8, 8, NULL, 2, 1, 18),
	(9, 8, NULL, 2, 2, 12),
	(10, 8, NULL, 2, 3, 4),
	(11, 8, 1, 2, 1, 1),
	(12, 8, 2, 2, 1, 1),
	(15, 17, NULL, 3, 1, 19),
	(16, 17, NULL, 3, 2, 12),
	(17, 17, NULL, 3, 3, 4),
	(18, 17, 19, 3, 1, 1),
	(22, 17, NULL, 4, 1, 19),
	(23, 17, NULL, 4, 2, 11),
	(24, 17, NULL, 4, 3, 4),
	(25, 17, 19, 4, 1, 1),
	(26, 17, 20, 4, 2, 1),
	(29, 17, NULL, 5, 1, 16),
	(30, 17, NULL, 5, 2, 11),
	(31, 17, NULL, 5, 3, 4),
	(32, 17, 19, 5, 1, 4),
	(33, 17, 20, 5, 2, 1),
	(36, 17, NULL, 6, 1, 16),
	(37, 17, NULL, 6, 2, 11),
	(38, 17, NULL, 6, 3, 3),
	(39, 17, 19, 6, 1, 4),
	(40, 17, 20, 6, 2, 1),
	(41, 17, 20, 6, 3, 1),
	(43, 17, NULL, 7, 1, 16),
	(44, 17, NULL, 7, 2, 11),
	(45, 17, NULL, 7, 3, 3),
	(46, 17, 19, 7, 1, 4),
	(47, 17, 20, 7, 2, 1),
	(48, 17, 20, 7, 3, 1),
	(50, 17, NULL, 8, 1, 16),
	(51, 17, NULL, 8, 2, 10),
	(52, 17, NULL, 8, 3, 3),
	(53, 17, 19, 8, 1, 4),
	(54, 17, 20, 8, 2, 2),
	(55, 17, 20, 8, 3, 1),
	(57, 18, NULL, 9, 1, 20),
	(58, 18, NULL, 9, 2, 12),
	(59, 18, NULL, 9, 3, 4),
	(60, 18, NULL, 10, 1, 19),
	(61, 18, NULL, 10, 2, 12),
	(62, 18, NULL, 10, 3, 4),
	(63, 18, 22, 10, 1, 1),
	(67, 19, NULL, 11, 1, 19),
	(68, 19, NULL, 11, 2, 12),
	(69, 19, NULL, 11, 3, 4),
	(70, 19, 23, 11, 1, 1),
	(74, 19, NULL, 12, 1, 18),
	(75, 19, NULL, 12, 2, 12),
	(76, 19, NULL, 12, 3, 4),
	(77, 19, 23, 12, 1, 1),
	(78, 19, 24, 12, 1, 1),
	(81, 19, NULL, 13, 1, 18),
	(82, 19, NULL, 13, 2, 12),
	(83, 19, NULL, 13, 3, 4),
	(84, 19, 23, 13, 1, 1),
	(85, 19, 24, 13, 1, 1),
	(88, 19, NULL, 14, 1, 17),
	(89, 19, NULL, 14, 2, 12),
	(90, 19, NULL, 14, 3, 4),
	(91, 19, 23, 14, 1, 1),
	(92, 19, 24, 14, 1, 2),
	(95, 19, NULL, 15, 1, 17),
	(96, 19, NULL, 15, 2, 12),
	(97, 19, NULL, 15, 3, 4),
	(98, 19, 23, 15, 1, 1),
	(99, 19, 24, 15, 1, 2),
	(102, 19, NULL, 16, 1, 17),
	(103, 19, NULL, 16, 2, 12),
	(104, 19, NULL, 16, 3, 3),
	(105, 19, 23, 16, 1, 1),
	(106, 19, 24, 16, 1, 2),
	(107, 19, 24, 16, 3, 1),
	(109, 19, NULL, 17, 1, 17),
	(110, 19, NULL, 17, 2, 12),
	(111, 19, NULL, 17, 3, 3),
	(112, 19, 23, 17, 1, 1),
	(113, 19, 24, 17, 1, 2),
	(114, 19, 24, 17, 3, 1),
	(116, 19, NULL, 18, 1, 16),
	(117, 19, NULL, 18, 2, 12),
	(118, 19, NULL, 18, 3, 3),
	(119, 19, 23, 18, 1, 1),
	(120, 19, 24, 18, 1, 3),
	(121, 19, 24, 18, 3, 1),
	(123, 19, NULL, 19, 1, 16),
	(124, 19, NULL, 19, 2, 12),
	(125, 19, NULL, 19, 3, 3),
	(126, 19, 23, 19, 1, 1),
	(127, 19, 24, 19, 1, 3),
	(128, 19, 24, 19, 3, 1),
	(130, 19, NULL, 20, 1, 15),
	(131, 19, NULL, 20, 2, 12),
	(132, 19, NULL, 20, 3, 3),
	(133, 19, 23, 20, 1, 1),
	(134, 19, 24, 20, 1, 4),
	(135, 19, 24, 20, 3, 1),
	(137, 19, NULL, 21, 1, 15),
	(138, 19, NULL, 21, 2, 12),
	(139, 19, NULL, 21, 3, 3),
	(140, 19, 23, 21, 1, 1),
	(141, 19, 24, 21, 1, 4),
	(142, 19, 24, 21, 3, 1),
	(144, 19, NULL, 22, 1, 15),
	(145, 19, NULL, 22, 2, 12),
	(146, 19, NULL, 22, 3, 2),
	(147, 19, 23, 22, 1, 1),
	(148, 19, 24, 22, 1, 4),
	(149, 19, 24, 22, 3, 2),
	(151, 19, NULL, 23, 1, 15),
	(152, 19, NULL, 23, 2, 12),
	(153, 19, NULL, 23, 3, 2),
	(154, 19, 23, 23, 1, 1),
	(155, 19, 24, 23, 1, 4),
	(156, 19, 24, 23, 3, 2),
	(158, 19, NULL, 24, 1, 14),
	(159, 19, NULL, 24, 2, 12),
	(160, 19, NULL, 24, 3, 2),
	(161, 19, 23, 24, 1, 1),
	(162, 19, 24, 24, 1, 5),
	(163, 19, 24, 24, 3, 2),
	(165, 19, NULL, 25, 1, 14),
	(166, 19, NULL, 25, 2, 12),
	(167, 19, NULL, 25, 3, 2),
	(168, 19, 23, 25, 1, 1),
	(169, 19, 24, 25, 1, 5),
	(170, 19, 24, 25, 3, 2),
	(172, 19, NULL, 26, 1, 13),
	(173, 19, NULL, 26, 2, 12),
	(174, 19, NULL, 26, 3, 2),
	(175, 19, 23, 26, 1, 1),
	(176, 19, 24, 26, 1, 6),
	(177, 19, 24, 26, 3, 2),
	(179, 19, NULL, 27, 1, 13),
	(180, 19, NULL, 27, 2, 12),
	(181, 19, NULL, 27, 3, 2),
	(182, 19, 23, 27, 1, 1),
	(183, 19, 24, 27, 1, 6),
	(184, 19, 24, 27, 3, 2),
	(186, 19, NULL, 28, 1, 12),
	(187, 19, NULL, 28, 2, 12),
	(188, 19, NULL, 28, 3, 2),
	(189, 19, 23, 28, 1, 1),
	(190, 19, 24, 28, 1, 7),
	(191, 19, 24, 28, 3, 2),
	(193, 19, NULL, 29, 1, 12),
	(194, 19, NULL, 29, 2, 12),
	(195, 19, NULL, 29, 3, 2),
	(196, 19, 23, 29, 1, 1),
	(197, 19, 24, 29, 1, 7),
	(198, 19, 24, 29, 3, 2),
	(200, 19, NULL, 30, 1, 11),
	(201, 19, NULL, 30, 2, 12),
	(202, 19, NULL, 30, 3, 2),
	(203, 19, 23, 30, 1, 1),
	(204, 19, 24, 30, 1, 8),
	(205, 19, 24, 30, 3, 2),
	(207, 19, NULL, 31, 1, 11),
	(208, 19, NULL, 31, 2, 12),
	(209, 19, NULL, 31, 3, 2),
	(210, 19, 23, 31, 1, 1),
	(211, 19, 24, 31, 1, 8),
	(212, 19, 24, 31, 3, 2),
	(214, 19, NULL, 32, 1, 11),
	(215, 19, NULL, 32, 2, 11),
	(216, 19, NULL, 32, 3, 2),
	(217, 19, 23, 32, 1, 1),
	(218, 19, 24, 32, 1, 8),
	(219, 19, 24, 32, 2, 1),
	(220, 19, 24, 32, 3, 2);
/*!40000 ALTER TABLE `game_rate_hist` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.game_step
CREATE TABLE IF NOT EXISTS `game_step` (
  `game_step_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) DEFAULT NULL,
  `step_game_player_id` int(11) DEFAULT NULL,
  `trand_value` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`game_step_id`),
  KEY `FK_game_step_game` (`game_id`),
  KEY `FK_game_step_player` (`step_game_player_id`),
  CONSTRAINT `FK_game_step_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FK_game_step_game_player` FOREIGN KEY (`step_game_player_id`) REFERENCES `game_player` (`game_player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.game_step: ~8 rows (приблизительно)
DELETE FROM `game_step`;
/*!40000 ALTER TABLE `game_step` DISABLE KEYS */;
INSERT INTO `game_step` (`game_step_id`, `game_id`, `step_game_player_id`, `trand_value`) VALUES
	(1, 8, 1, -2.00),
	(2, 8, 2, 4.00),
	(3, 17, 19, 2.00),
	(4, 17, 20, 2.00),
	(5, 17, 19, 5.00),
	(6, 17, 20, 0.00),
	(7, 17, 19, 1.00),
	(8, 17, 20, -3.00),
	(9, 18, 21, 2.00),
	(10, 18, 22, -1.00),
	(11, 19, 23, 1.00),
	(12, 19, 24, -2.00),
	(13, 19, 23, 2.00),
	(14, 19, 24, 1.00),
	(15, 19, 23, -2.00),
	(16, 19, 24, 0.00),
	(17, 19, 23, 1.00),
	(18, 19, 24, 0.00),
	(19, 19, 23, 0.00),
	(20, 19, 24, -3.00),
	(21, 19, 23, 2.00),
	(22, 19, 24, 1.00),
	(23, 19, 23, -2.00),
	(24, 19, 24, 2.00),
	(25, 19, 23, 0.00),
	(26, 19, 24, 0.00),
	(27, 19, 23, 0.00),
	(28, 19, 24, 1.00),
	(29, 19, 23, 1.00),
	(30, 19, 24, 1.00),
	(31, 19, 23, -1.00),
	(32, 19, 24, -1.00);
/*!40000 ALTER TABLE `game_step` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.game_step_results
CREATE TABLE IF NOT EXISTS `game_step_results` (
  `game_step_result_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_player_id` int(11) DEFAULT NULL,
  `game_id` int(11) DEFAULT NULL,
  `game_step_id` int(11) DEFAULT NULL,
  `game_step_result` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`game_step_result_id`),
  KEY `FK_game_step_results_game_player` (`game_player_id`),
  KEY `FK_game_step_results_game` (`game_id`),
  KEY `FK_game_step_results_game_step` (`game_step_id`),
  CONSTRAINT `FK_game_step_results_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FK_game_step_results_game_player` FOREIGN KEY (`game_player_id`) REFERENCES `game_player` (`game_player_id`),
  CONSTRAINT `FK_game_step_results_game_step` FOREIGN KEY (`game_step_id`) REFERENCES `game_step` (`game_step_id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы conjuncture.game_step_results: ~16 rows (приблизительно)
DELETE FROM `game_step_results`;
/*!40000 ALTER TABLE `game_step_results` DISABLE KEYS */;
INSERT INTO `game_step_results` (`game_step_result_id`, `game_player_id`, `game_id`, `game_step_id`, `game_step_result`) VALUES
	(1, 1, 8, 1, -400.00),
	(2, 2, 8, 1, 0.00),
	(4, 1, 8, 2, 800.00),
	(5, 2, 8, 2, 800.00),
	(7, 19, 17, 3, 400.00),
	(8, 20, 17, 3, 0.00),
	(10, 19, 17, 4, 400.00),
	(11, 20, 17, 4, 1200.00),
	(13, 19, 17, 5, 4000.00),
	(14, 20, 17, 5, 3000.00),
	(16, 19, 17, 6, 0.00),
	(17, 20, 17, 6, 0.00),
	(19, 19, 17, 7, 800.00),
	(20, 20, 17, 7, 1800.00),
	(22, 19, 17, 8, -2400.00),
	(23, 20, 17, 8, -7200.00),
	(25, 21, 18, 9, 0.00),
	(26, 22, 18, 9, 0.00),
	(28, 21, 18, 10, 0.00),
	(29, 22, 18, 10, -200.00),
	(31, 23, 19, 11, 200.00),
	(32, 24, 19, 11, 0.00),
	(34, 23, 19, 12, -400.00),
	(35, 24, 19, 12, -400.00),
	(37, 23, 19, 13, 400.00),
	(38, 24, 19, 13, 400.00),
	(40, 23, 19, 14, 200.00),
	(41, 24, 19, 14, 400.00),
	(43, 23, 19, 15, -400.00),
	(44, 24, 19, 15, -800.00),
	(46, 23, 19, 16, 0.00),
	(47, 24, 19, 16, 0.00),
	(49, 23, 19, 17, 200.00),
	(50, 24, 19, 17, 1600.00),
	(52, 23, 19, 18, 0.00),
	(53, 24, 19, 18, 0.00),
	(55, 23, 19, 19, 0.00),
	(56, 24, 19, 19, 0.00),
	(58, 23, 19, 20, -600.00),
	(59, 24, 19, 20, -6000.00),
	(61, 23, 19, 21, 400.00),
	(62, 24, 19, 21, 4000.00),
	(64, 23, 19, 22, 200.00),
	(65, 24, 19, 22, 3200.00),
	(67, 23, 19, 23, -400.00),
	(68, 24, 19, 23, -6400.00),
	(70, 23, 19, 24, 400.00),
	(71, 24, 19, 24, 6800.00),
	(73, 23, 19, 25, 0.00),
	(74, 24, 19, 25, 0.00),
	(76, 23, 19, 26, 0.00),
	(77, 24, 19, 26, 0.00),
	(79, 23, 19, 27, 0.00),
	(80, 24, 19, 27, 0.00),
	(82, 23, 19, 28, 200.00),
	(83, 24, 19, 28, 3800.00),
	(85, 23, 19, 29, 200.00),
	(86, 24, 19, 29, 3800.00),
	(88, 23, 19, 30, 200.00),
	(89, 24, 19, 30, 4000.00),
	(91, 23, 19, 31, -200.00),
	(92, 24, 19, 31, -4000.00),
	(94, 23, 19, 32, -200.00),
	(95, 24, 19, 32, -4600.00);
/*!40000 ALTER TABLE `game_step_results` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.invites
CREATE TABLE IF NOT EXISTS `invites` (
  `invite_id` int(11) NOT NULL AUTO_INCREMENT,
  `player_from` int(11) NOT NULL,
  `player_to` int(11) NOT NULL,
  `status_value` varchar(20) DEFAULT NULL,
  `date_from` datetime DEFAULT NULL,
  `game_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`invite_id`),
  KEY `FK_invites_player` (`player_from`),
  KEY `FK_invites_player_2` (`player_to`),
  KEY `FK_invites_game` (`game_id`),
  CONSTRAINT `FK_invites_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FK_invites_player` FOREIGN KEY (`player_from`) REFERENCES `player` (`player_id`),
  CONSTRAINT `FK_invites_player_2` FOREIGN KEY (`player_to`) REFERENCES `player` (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы conjuncture.invites: ~0 rows (приблизительно)
DELETE FROM `invites`;
/*!40000 ALTER TABLE `invites` DISABLE KEYS */;
/*!40000 ALTER TABLE `invites` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.player
CREATE TABLE IF NOT EXISTS `player` (
  `player_id` int(11) NOT NULL AUTO_INCREMENT,
  `player_log` varchar(50) NOT NULL,
  `player_phone` varchar(50) NOT NULL,
  `player_pass` varchar(100) NOT NULL,
  `player_first_name` varchar(100) NOT NULL,
  `player_last_name` varchar(100) NOT NULL,
  `player_middle_name` varchar(100) NOT NULL,
  `player_birth_date` date NOT NULL,
  `player_ava` varchar(200) DEFAULT NULL,
  `player_email` varchar(200) NOT NULL,
  `balance` decimal(10,2) NOT NULL,
  `registration_date` datetime NOT NULL,
  `rating` decimal(10,2) NOT NULL,
  `uploadnum` int(11) NOT NULL,
  `last_activity` datetime NOT NULL,
  PRIMARY KEY (`player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.player: ~4 rows (приблизительно)
DELETE FROM `player`;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` (`player_id`, `player_log`, `player_phone`, `player_pass`, `player_first_name`, `player_last_name`, `player_middle_name`, `player_birth_date`, `player_ava`, `player_email`, `balance`, `registration_date`, `rating`, `uploadnum`, `last_activity`) VALUES
	(1, 'SemenovNA', '78949', '7', 'Nick', 'Sem', 'And', '1985-07-20', NULL, 'nick@mail.ru', 0.00, '2017-01-01 00:00:00', 12.00, 0, '2017-05-08 20:04:34'),
	(2, 'tutunia', '435', '8', 'Serg', 'Tut', 'A', '2016-08-01', 'tutunia_1.png', 'hth@mail.ru', 1000.00, '2017-02-01 00:00:00', 9.10, 1, '2017-01-02 00:00:00'),
	(3, 'k', '+79162664924', '7', 'kalistrat', 'kalistratov', 'koldybovich', '1985-06-26', 'k_12.png', 'kauredinas@mail.ru', 48347.00, '2017-03-01 00:00:00', 77.70, 12, '2017-05-09 00:05:38'),
	(4, 'ADMIN', '0', '7onofN', 'ADMIN', 'ADMIN', 'ADMIN', '2016-08-09', NULL, 'admin@mail.ru', 500000.00, '2017-04-01 00:00:00', 2.00, 0, '2017-01-02 00:00:00');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;


-- Дамп структуры для процедура conjuncture.p_area_filed_insert
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_area_filed_insert`(eAreaTypeId int,eFieldTypeId int,eFieldIndex text)
begin

insert into area_field(area_type_id,field_type_id,field_index)
values (eAreaTypeId,eFieldTypeId,eFieldIndex);

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_buy_game_field
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_buy_game_field`(IN `eGameId` int, IN `eGamePlayerId` INT, IN `eFieldIndex` varchar(5))
begin
declare i_game_field_id int;
declare i_field_price decimal(10,2);

select gf.game_field_id
,ft.field_price
into i_game_field_id
,i_field_price
from game_field gf
join field_type ft on ft.field_type_id=gf.field_type_id
where gf.game_id=eGameId
and gf.field_index=eFieldIndex;


update game_field gf
set gf.game_player_id=eGamePlayerId
where gf.field_index=eFieldIndex
and gf.game_id=eGameId;

update game_player gp
set gp.current_passiv_value=gp.current_passiv_value-i_field_price
where gp.game_player_id=eGamePlayerId
and gp.game_id=eGameId;

#insert into game_rate(game_id, game_player_id,game_field_id)
#values(eGameId,i_game_player_id,i_game_field_id);

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_buy_game_fields_by_admin
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_buy_game_fields_by_admin`(IN `eGameId` int)
begin
declare i_cnt_free_rows int;
declare i_num_engage_row int;
declare i_game_field_id int;
declare i_field_price decimal(10,2);
declare i_game_player_id int;

select count(*) into i_cnt_free_rows
from game_field gf
where gf.game_id=eGameId
and gf.game_player_id is null;

if (i_cnt_free_rows != 0) then
	select 1+floor(i_cnt_free_rows*rand()) into i_num_engage_row;
	
	select t.game_field_id
	,t.field_price
	into i_game_field_id
	,i_field_price
	from (
	select gf.game_field_id
	,ft.field_price
	,@num := @num +1 row_number
	from game_field gf
	join field_type ft on ft.field_type_id=gf.field_type_id
	join (select @num:=0) tnum
	where gf.game_id=eGameId
	and gf.game_player_id is null
	order by gf.game_field_id
	) t
	where t.row_number = i_num_engage_row;
	
	set i_game_player_id = f_get_game_player_id(eGameId,'ADMIN');
	
	update game_field gfi
	set gfi.game_player_id=i_game_player_id
	where gfi.game_field_id=i_game_field_id
	and gfi.game_id=eGameId;
	
	update game_player gpl
	set gpl.current_passiv_value=gpl.current_passiv_value-i_field_price
	where gpl.game_player_id=i_game_player_id
	and gpl.game_id=eGameId;

end if;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_buy_game_fields_by_user
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_buy_game_fields_by_user`(IN `eGameFields` TEXT, IN `eGamePlayerId` INT, IN `eGameId` INT)
begin
declare i_value_count int;
declare i_value_index varchar(5);
declare i int default 1;
declare i_is_user_engaged int;


set i_value_count=extractvalue(eGameFields, 'count(/list/string)');

/*
insert into game_log(var_name,var_val)
values('i_value_count',i_value_count);
*/

while (i<=i_value_count) do

set i_value_index = extractvalue(eGameFields, '/list/string[$i]');
set i_is_user_engaged = f_is_user_engaged(eGameId,eGamePlayerId,i_value_index);

if (i_is_user_engaged = 0) then
call p_buy_game_field(eGameId,eGamePlayerId,i_value_index);
end if;

set i=i+1;
end while;


end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_buy_game_field_n
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_buy_game_field_n`(IN `eGameId` int, IN `ePlayerLog` VARCHAR(20), IN `eFieldIndex` varchar(5))
begin
declare i_game_field_id int;
declare i_field_price decimal(10,2);
declare i_game_player_id int;

select gf.game_field_id
,ft.field_price
into i_game_field_id
,i_field_price
from game_field gf
join field_type ft on ft.field_type_id=gf.field_type_id
where gf.game_id=eGameId
and gf.field_index=eFieldIndex;

set i_game_player_id = f_get_game_player_id(eGameId,ePlayerLog);

update game_field gf
set gf.game_player_id=i_game_player_id
where gf.field_index=eFieldIndex
and gf.game_id=eGameId;

update game_player gp
set gp.current_passiv_value=gp.current_passiv_value-i_field_price
where gp.game_player_id=i_game_player_id
and gp.game_id=eGameId;

call p_game_activity_update(eGameId);
call p_player_activity_update(ePlayerLog);

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_calc_step_results
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_calc_step_results`(IN `eGameId` int)
begin

declare i_last_step_id int;
declare i_trand_value int;

select max(gsp.game_step_id) into i_last_step_id
from game_step gsp
where gsp.game_id=eGameId;

select gsp.trand_value into i_trand_value
from game_step gsp
where gsp.game_step_id=i_last_step_id;

insert into game_step_results(
game_player_id
,game_id
,game_step_id
,game_step_result
)
select w.game_player_id
,w.game_id
,w.game_step_id
,sum(w.game_step_result) game_step_result
from (
select a.*
,i_last_step_id game_step_id 
,ifnull(b.field_value,0)*ifnull(b.field_price,0)*ifnull(b.cnt_fields,0)*i_trand_value game_step_result
from (
select gpl.game_player_id
,gpl.game_id
from game_player gpl
where gpl.game_id=eGameId
) a
left join (
select gf.game_player_id
,gf.game_id
,ft.field_type_id
,ft.field_price
,ft.field_value
,ft.filed_color
,count(*) cnt_fields
from game_field gf
join field_type ft on ft.field_type_id=gf.field_type_id
where gf.game_id=eGameId
group by gf.game_player_id
,gf.game_id
,ft.field_type_id
,ft.field_price
,ft.field_value
,ft.filed_color
) b
on a.game_player_id=b.game_player_id 
and a.game_id=b.game_id
) w
group by w.game_player_id
,w.game_id
,w.game_step_id;

update game_player gpl
join (
select gres.*
from game_step_results gres
where gres.game_id=eGameId
and gres.game_step_id=i_last_step_id
) w
on gpl.game_player_id=w.game_player_id
set gpl.current_passiv_value=gpl.current_passiv_value+w.game_step_result
where gpl.game_id=eGameId;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_close_game_player
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_close_game_player`(IN `eGameId` int, IN `eUserLog` varchar(50))
begin
declare i_total_value decimal(10,2);
declare i_game_player_id int;

set i_game_player_id = f_get_game_player_id(eGameId,eUserLog);

select t.passiv_value+t.sale_rates_value into i_total_value
from (
select gp.game_player_id
,ifnull(gp.current_passiv_value,0) passiv_value
,ifnull(sum(ft.field_price),0) sale_rates_value
from game_player gp
join player p on p.player_id=gp.player_id
left join game_field gf on gf.game_player_id=gp.game_player_id
left join field_type ft on ft.field_type_id = gf.field_type_id
where gp.game_id=eGameId
and p.player_log=eUserLog
group by gp.game_player_id
,gp.current_passiv_value
) t;

update game_player gp
set gp.is_active=0
,gp.current_passiv_value=0
,gp.out_time=sysdate()
,gp.out_passiv_value=i_total_value
where gp.game_player_id = i_game_player_id;

update game_field gf
set gf.game_player_id=null
where gf.game_id = eGameId
and gf.game_player_id=i_game_player_id;

update player p
set p.balance=p.balance + i_total_value
where p.player_log = eUserLog;

call p_game_activity_update(eGameId);
call p_player_activity_update(eUserLog);


end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_game_activity_update
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_game_activity_update`(eGameId int)
begin

update game g
set g.last_activity = sysdate()
where g.game_id = eGameId;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_game_field_insert
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_game_field_insert`(eGameid int)
begin
declare i_area_type_id int;

select g.area_type_id into i_area_type_id
from game g
where g.game_id=eGameid;

insert into game_field(game_id,field_value,field_index,field_type_id)
select eGameid
,ft.field_value
,af.field_index
,af.field_type_id 
from area_field af
join field_type ft on ft.field_type_id=af.field_type_id 
where af.area_type_id=i_area_type_id;


end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_game_invate_add
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_game_invate_add`(eUserFrom varchar(50)
,eGameTo int
)
begin

insert into invites(
player_from
,player_to
,status_value
,date_from
,game_id
) 
select pfrom.player_id player_from
,(
select p.player_id
from game g
join player p on p.player_id=g.create_player_id
where g.game_id=eGameTo
) player_to
,'в ожидании' status_value
,sysdate() date_from
,eGameTo
from player pfrom
where pfrom.player_log=eUserFrom;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_game_player_insert
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_game_player_insert`(IN `eGameId` int, IN `ePassiv` decimal(10,2), IN `eUserLog` VARCHAR(50))
begin

insert into game_player(game_id
,player_id
,in_time
,in_passiv_value
,current_passiv_value
,player_sym
,order_connect
,is_steping
,is_active
,start_steping
)
select g.game_id
,(
select p.player_id
from player p
where p.player_log=eUserLog
) player_id
,sysdate() in_time
,ePassiv in_passiv_value
,ePassiv current_passiv_value
,concat(substring((
select lower(p.player_log)
from player p
where p.player_log=eUserLog
),1,1)
,(
select count(*)
from game_player gp
where gp.game_id=g.game_id
) + 1) player_sym
,(
select count(*)
from game_player gp
where gp.game_id=g.game_id
) + 1 order_connect
,0 is_steping
,1 is_active
,sysdate() start_steping
from game g
where g.game_id=eGameId;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_game_rate_hist
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_game_rate_hist`(jGame int,jGameStepId int)
begin

insert into game_rate_hist(
game_id
,game_player_id
,game_step_id
,field_type_id
,fields_count
)
select gf.game_id
,game_player_id
,jGameStepId game_step_id
,gf.field_type_id
,count(*) fields_count
from game_field gf
join field_type ft on ft.field_type_id=gf.field_type_id
where gf.game_id=jGame
group by gf.game_id
,game_player_id
,gf.field_type_id;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_invite_update
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_invite_update`(eINviteId int,eStatus varchar(20))
begin

update invites inv
set inv.status_value=eStatus
where inv.invite_id=eINviteId;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_make_game_step
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_make_game_step`(IN `eGameId` INT, IN `ePlayerLog` VARCHAR(20), IN `eGameFields` TEXT)
begin
declare i_res_trand_value_1 int;
declare i_res_trand_value_2 int;

declare i_game_player_id int;
declare i_IsSingleGame int;
declare i_admin_game_player_id int;

select gg.is_single_game into i_IsSingleGame
from game gg
where gg.game_id=eGameId;


set i_game_player_id = f_get_game_player_id(eGameId,ePlayerLog);

set i_res_trand_value_1 = f_generate_trand_value();

insert into game_step(game_id,step_game_player_id,trand_value)
values(eGameId,i_game_player_id,i_res_trand_value_1);

call p_sell_game_fields_by_user(eGameFields, i_game_player_id, eGameId);
call p_buy_game_fields_by_user(eGameFields, i_game_player_id, eGameId);

call p_switch_game_player(eGameId);

if (i_IsSingleGame = 1) then
call p_buy_game_fields_by_admin(eGameId);
set i_admin_game_player_id = f_get_game_player_id(eGameId,'ADMIN');
set i_res_trand_value_2 = f_generate_trand_value();

insert into game_step(game_id,step_game_player_id,trand_value)
values(eGameId,i_admin_game_player_id,i_res_trand_value_2);

call p_switch_game_player(eGameId);
end if;


end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_make_game_step_n
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_make_game_step_n`(IN `eGameId` INT, IN `ePlayerLog` VARCHAR(20))
begin
declare i_res_trand_value_1 int;
declare i_res_trand_value_2 int;

declare i_game_player_id int;
declare i_IsSingleGame int;
declare i_admin_game_player_id int;
declare i_game_step_id int;

select gg.is_single_game into i_IsSingleGame
from game gg
where gg.game_id=eGameId;


set i_game_player_id = f_get_game_player_id(eGameId,ePlayerLog);

set i_res_trand_value_1 = f_generate_trand_value();

insert into game_step(game_id,step_game_player_id,trand_value)
values(eGameId,i_game_player_id,i_res_trand_value_1);

select max(gsp.game_step_id) into i_game_step_id
from game_step gsp
where gsp.game_id=eGameId;

call p_game_rate_hist(eGameId,i_game_step_id);
call p_calc_step_results(eGameId);
call p_switch_game_player(eGameId);

call p_game_activity_update(eGameId);
call p_player_activity_update(ePlayerLog);


if (i_IsSingleGame = 1) then
call p_buy_game_fields_by_admin(eGameId);
set i_admin_game_player_id = f_get_game_player_id(eGameId,'ADMIN');
set i_res_trand_value_2 = f_generate_trand_value();

insert into game_step(game_id,step_game_player_id,trand_value)
values(eGameId,i_admin_game_player_id,i_res_trand_value_2);

select max(gsp.game_step_id) into i_game_step_id
from game_step gsp
where gsp.game_id=eGameId;

call p_game_rate_hist(eGameId,i_game_step_id);
call p_calc_step_results(eGameId);
call p_switch_game_player(eGameId);

end if;


end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_player_activity_update
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_player_activity_update`(eUserLog varchar(50))
begin

update player p
set p.last_activity=sysdate()
where p.player_log = eUserLog;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_player_invate_add
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_player_invate_add`(eUserFrom varchar(50)
,eUserTo varchar(50)
)
begin

insert into invites(
player_from
,player_to
,status_value
,date_from
,game_id
) 
select pfrom.player_id player_from
,(
select pto.player_id
from player pto
where pto.player_log=eUserTo
) player_to
,'в ожидании' status_value
,sysdate() date_from
,(
select max(g.game_id)
from game g
join player p on p.player_id=g.create_player_id
where p.player_log=eUserFrom
) game_id
from player pfrom
where pfrom.player_log=eUserFrom;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_sell_game_field
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_sell_game_field`(IN `eGameId` int, IN `eGamePlayerId` varchar(20), IN `eFieldIndex` varchar(5))
begin
declare i_game_field_id int;
declare i_field_price decimal(10,2);

select gf.game_field_id
,ft.field_price
into i_game_field_id
,i_field_price
from game_field gf
join field_type ft on ft.field_type_id=gf.field_type_id
where gf.game_id=eGameId
and gf.field_index=eFieldIndex;

update game_field gf
set gf.game_player_id=null
where gf.game_field_id=i_game_field_id;

update game_player gp
set gp.current_passiv_value=gp.current_passiv_value+i_field_price
where gp.game_player_id=eGamePlayerId;

#delete from game_rate
#where game_id=eGameId
#and game_field_id=i_game_field_id
#and game_step_id is null;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_sell_game_fields_by_user
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_sell_game_fields_by_user`(IN `eGameFields` TEXT, IN `eGamePlayerId` INT, IN `eGameId` INT)
begin
declare i int default 1;
declare i_value_count int;
declare i_cnt_engaged int;
declare i_value_index varchar(5);
declare i_is_user_engaged int;
declare i_game_field_index varchar(5);
declare i_is_user_engaging_field int;

Declare done integer default 0;

declare cur cursor for
select gf.field_index
from game_field gf
where gf.game_id=eGameId
and gf.game_player_id=eGamePlayerId;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

set i_value_count:=extractvalue(eGameFields, 'count(/list/string)');

select count(*) into i_cnt_engaged
from game_field gf
where gf.game_id=eGameId
and gf.game_player_id=eGamePlayerId;

if (i_cnt_engaged>0) then

	open cur;
	
WHILE done = 0 DO

	    FETCH cur INTO i_game_field_index;
	    
	    #insert into game_log(var_name,var_val)
	    #values('i_game_field_index',i_game_field_index);
	    
	    set i_is_user_engaging_field = f_is_user_engaging_field(eGameFields,i_game_field_index);
	    
	    if (i_is_user_engaging_field = 0) then
	    call p_sell_game_field(eGameId,eGamePlayerId,i_game_field_index);
	    end if;
	
END WHILE;
	
	close cur;

end if;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_sell_game_field_n
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_sell_game_field_n`(IN `eGameId` int, IN `ePlayerLog` varchar(20), IN `eFieldIndex` varchar(5))
begin
declare i_game_field_id int;
declare i_field_price decimal(10,2);
declare i_game_player_id int;

select gf.game_field_id
,ft.field_price
into i_game_field_id
,i_field_price
from game_field gf
join field_type ft on ft.field_type_id=gf.field_type_id
where gf.game_id=eGameId
and gf.field_index=eFieldIndex;

set i_game_player_id = f_get_game_player_id(eGameId, ePlayerLog);

update game_field gf
set gf.game_player_id=null
where gf.game_field_id=i_game_field_id;

update game_player gp
set gp.current_passiv_value=gp.current_passiv_value+i_field_price
where gp.game_player_id=i_game_player_id
and gp.game_id=eGameId;

call p_game_activity_update(eGameId);
call p_player_activity_update(ePlayerLog);

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_set_game_field_owner
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_set_game_field_owner`(eGameId int, eGamePlayerId int, eFieldIndex varchar(5))
begin
declare i_game_field_id int;

select gf.game_field_id into i_game_field_id
from game_field gf
where gf.game_id = eGameId
and gf.field_index = eFieldIndex;

update game_field gf
set gf.game_player_id=eGamePlayerId
where gf.game_field_id=i_game_field_id;

insert into game_rate(game_id, game_player_id,game_field_id)
values(eGameId,eGamePlayerId,i_game_field_id);

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_switch_game_player
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_switch_game_player`(IN `eGameId` int)
begin
declare i_next_game_player_id int;

select min(gp5.game_player_id) into i_next_game_player_id
from game_player gp5
where gp5.game_id=eGameId
and gp5.start_steping= (
select min(gp4.start_steping)
from game_player gp4
where gp4.game_id = eGameId
and gp4.is_active = 1
);


update game_player gp1
set gp1.is_steping=1
,gp1.start_steping=sysdate()
where gp1.game_id=eGameId
and gp1.game_player_id = i_next_game_player_id;

update game_player gp1
set gp1.is_steping=0
where gp1.game_id=eGameId
and gp1.game_player_id != i_next_game_player_id;


end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_user_ava_update
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_user_ava_update`(eUserLog varchar(50),eUserAvaAddress varchar(200))
begin

update player p
set p.player_ava=eUserAvaAddress
where p.player_log=eUserLog;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_user_contact_data_update
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_user_contact_data_update`(
eUserLog varchar(50)
,eMailValue varchar(200)
,ePhoneValue varchar(50)
)
begin

update player p
set p.player_email=trim(eMailValue)
,p.player_phone=trim(ePhoneValue)
where p.player_log=eUserLog;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_user_person_data_update
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_user_person_data_update`(
eUserLog varchar(50)
,eFirstNameValue varchar(100)
,eLastNameValue varchar(100)
,eMiddleNameValue varchar(100)
,eBirthDateValue date
)
begin

update player p
set p.player_first_name=trim(eFirstNameValue)
,p.player_last_name=trim(eLastNameValue)
,p.player_middle_name=trim(eMiddleNameValue)
,p.player_birth_date=eBirthDateValue
where p.player_log=eUserLog;

end//
DELIMITER ;


-- Дамп структуры для таблица conjuncture.test_refresh
CREATE TABLE IF NOT EXISTS `test_refresh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `val` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы conjuncture.test_refresh: ~7 rows (приблизительно)
DELETE FROM `test_refresh`;
/*!40000 ALTER TABLE `test_refresh` DISABLE KEYS */;
INSERT INTO `test_refresh` (`id`, `val`) VALUES
	(1, 'qqq'),
	(2, 'www'),
	(3, 'rrr'),
	(4, 'ttt'),
	(5, 'yyy'),
	(6, 'jyjhh'),
	(7, 'ffff');
/*!40000 ALTER TABLE `test_refresh` ENABLE KEYS */;


-- Дамп структуры для таблица conjuncture.test_xml
CREATE TABLE IF NOT EXISTS `test_xml` (
  `xmlval` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы conjuncture.test_xml: ~1 rows (приблизительно)
DELETE FROM `test_xml`;
/*!40000 ALTER TABLE `test_xml` DISABLE KEYS */;
INSERT INTO `test_xml` (`xmlval`) VALUES
	('<selected_fields>\r\n<field>324</field>\r\n<field>678</field>\r\n<field>17289</field>\r\n</selected_fields>');
/*!40000 ALTER TABLE `test_xml` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
