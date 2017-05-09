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


-- Дамп структуры для функция conjuncture.f_get_game_player_sym
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_get_game_player_sym`(eGameId int,eUserLog varchar(50)) RETURNS char(2) CHARSET utf8
begin
return(
select gp.player_sym
from game_player gp
join player p on p.player_id=gp.player_id
where gp.game_id = eGameId
and p.player_log = eUserLog
);
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


-- Дамп структуры для функция conjuncture.f_web_user_status
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` FUNCTION `f_web_user_status`(eGameId int,eUserLog varchar(50)) RETURNS char(1) CHARSET utf8
begin

return(
select gp.game_status
from game_player gp
join player p on p.player_id=gp.player_id
where gp.game_id=eGameId
and p.player_log=eUserLog
);

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.game: ~4 rows (приблизительно)
DELETE FROM `game`;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` (`game_id`, `date_from`, `date_till`, `create_player_id`, `area_type_id`, `is_single_game`, `last_activity`, `max_step_time`) VALUES
	(21, '2017-05-09 15:52:39', '2017-05-09 17:56:05', 3, 1, 1, '2017-05-09 17:32:01', 60),
	(22, '2017-05-09 19:43:09', '2017-05-09 20:38:53', 3, 1, 1, '2017-05-09 20:10:54', 60),
	(23, '2017-05-09 20:14:34', '2017-05-09 20:38:54', 3, 1, 1, '2017-05-09 20:17:54', 60),
	(24, '2017-05-09 20:39:54', '2017-05-09 20:44:56', 3, 1, 1, '2017-05-09 20:40:53', 60),
	(25, '2017-05-09 20:43:00', '2017-05-09 20:43:14', 3, 2, 1, '2017-05-09 20:43:14', 60),
	(26, '2017-05-09 20:45:02', '2017-05-09 20:45:09', 3, 2, 1, '2017-05-09 20:45:09', 60),
	(27, '2017-05-09 20:45:35', '2017-05-09 20:45:49', 3, 1, 1, '2017-05-09 20:45:49', 60),
	(28, '2017-05-09 20:45:56', '2017-05-09 20:46:13', 3, 1, 1, '2017-05-09 20:46:13', 60);
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
) ENGINE=InnoDB AUTO_INCREMENT=1425 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.game_field: ~144 rows (приблизительно)
DELETE FROM `game_field`;
/*!40000 ALTER TABLE `game_field` DISABLE KEYS */;
INSERT INTO `game_field` (`game_field_id`, `game_id`, `field_value`, `field_index`, `field_type_id`, `game_player_id`) VALUES
	(793, 21, 2.00, '00', 1, NULL),
	(794, 21, 2.00, '01', 1, NULL),
	(795, 21, 2.00, '02', 1, NULL),
	(796, 21, 2.00, '03', 1, NULL),
	(797, 21, 2.00, '04', 1, NULL),
	(798, 21, 2.00, '05', 1, NULL),
	(799, 21, 2.00, '10', 1, NULL),
	(800, 21, 2.00, '15', 1, NULL),
	(801, 21, 2.00, '20', 1, NULL),
	(802, 21, 2.00, '25', 1, NULL),
	(803, 21, 2.00, '30', 1, NULL),
	(804, 21, 2.00, '35', 1, NULL),
	(805, 21, 2.00, '40', 1, NULL),
	(806, 21, 2.00, '45', 1, NULL),
	(807, 21, 2.00, '50', 1, NULL),
	(808, 21, 2.00, '51', 1, NULL),
	(809, 21, 2.00, '52', 1, NULL),
	(810, 21, 2.00, '53', 1, NULL),
	(811, 21, 2.00, '54', 1, NULL),
	(812, 21, 2.00, '55', 1, NULL),
	(813, 21, 3.00, '11', 2, NULL),
	(814, 21, 3.00, '12', 2, NULL),
	(815, 21, 3.00, '13', 2, NULL),
	(816, 21, 3.00, '14', 2, NULL),
	(817, 21, 3.00, '21', 2, NULL),
	(818, 21, 3.00, '24', 2, NULL),
	(819, 21, 3.00, '31', 2, NULL),
	(820, 21, 3.00, '34', 2, NULL),
	(821, 21, 3.00, '41', 2, NULL),
	(822, 21, 3.00, '42', 2, NULL),
	(823, 21, 3.00, '43', 2, NULL),
	(824, 21, 3.00, '44', 2, NULL),
	(825, 21, 4.00, '22', 3, NULL),
	(826, 21, 4.00, '23', 3, NULL),
	(827, 21, 4.00, '32', 3, NULL),
	(828, 21, 4.00, '33', 3, NULL),
	(856, 22, 2.00, '00', 1, NULL),
	(857, 22, 2.00, '01', 1, 30),
	(858, 22, 2.00, '02', 1, NULL),
	(859, 22, 2.00, '03', 1, 30),
	(860, 22, 2.00, '04', 1, 30),
	(861, 22, 2.00, '05', 1, 30),
	(862, 22, 2.00, '10', 1, NULL),
	(863, 22, 2.00, '15', 1, 30),
	(864, 22, 2.00, '20', 1, NULL),
	(865, 22, 2.00, '25', 1, 30),
	(866, 22, 2.00, '30', 1, 30),
	(867, 22, 2.00, '35', 1, NULL),
	(868, 22, 2.00, '40', 1, 30),
	(869, 22, 2.00, '45', 1, 30),
	(870, 22, 2.00, '50', 1, 30),
	(871, 22, 2.00, '51', 1, NULL),
	(872, 22, 2.00, '52', 1, NULL),
	(873, 22, 2.00, '53', 1, NULL),
	(874, 22, 2.00, '54', 1, NULL),
	(875, 22, 2.00, '55', 1, NULL),
	(876, 22, 3.00, '11', 2, 30),
	(877, 22, 3.00, '12', 2, NULL),
	(878, 22, 3.00, '13', 2, 30),
	(879, 22, 3.00, '14', 2, 30),
	(880, 22, 3.00, '21', 2, 30),
	(881, 22, 3.00, '24', 2, NULL),
	(882, 22, 3.00, '31', 2, NULL),
	(883, 22, 3.00, '34', 2, 30),
	(884, 22, 3.00, '41', 2, 30),
	(885, 22, 3.00, '42', 2, NULL),
	(886, 22, 3.00, '43', 2, 30),
	(887, 22, 3.00, '44', 2, 30),
	(888, 22, 4.00, '22', 3, 30),
	(889, 22, 4.00, '23', 3, 30),
	(890, 22, 4.00, '32', 3, 30),
	(891, 22, 4.00, '33', 3, NULL),
	(919, 23, 2.00, '00', 1, 32),
	(920, 23, 2.00, '01', 1, 32),
	(921, 23, 2.00, '02', 1, 32),
	(922, 23, 2.00, '03', 1, 32),
	(923, 23, 2.00, '04', 1, 32),
	(924, 23, 2.00, '05', 1, 32),
	(925, 23, 2.00, '10', 1, 32),
	(926, 23, 2.00, '15', 1, 32),
	(927, 23, 2.00, '20', 1, 32),
	(928, 23, 2.00, '25', 1, 32),
	(929, 23, 2.00, '30', 1, 32),
	(930, 23, 2.00, '35', 1, 32),
	(931, 23, 2.00, '40', 1, 32),
	(932, 23, 2.00, '45', 1, 32),
	(933, 23, 2.00, '50', 1, 32),
	(934, 23, 2.00, '51', 1, 32),
	(935, 23, 2.00, '52', 1, 32),
	(936, 23, 2.00, '53', 1, 32),
	(937, 23, 2.00, '54', 1, 32),
	(938, 23, 2.00, '55', 1, 32),
	(939, 23, 3.00, '11', 2, 32),
	(940, 23, 3.00, '12', 2, 32),
	(941, 23, 3.00, '13', 2, 32),
	(942, 23, 3.00, '14', 2, 32),
	(943, 23, 3.00, '21', 2, 32),
	(944, 23, 3.00, '24', 2, 32),
	(945, 23, 3.00, '31', 2, 32),
	(946, 23, 3.00, '34', 2, 32),
	(947, 23, 3.00, '41', 2, 32),
	(948, 23, 3.00, '42', 2, 32),
	(949, 23, 3.00, '43', 2, 32),
	(950, 23, 3.00, '44', 2, 32),
	(951, 23, 4.00, '22', 3, 32),
	(952, 23, 4.00, '23', 3, 32),
	(953, 23, 4.00, '32', 3, 32),
	(954, 23, 4.00, '33', 3, 32),
	(982, 24, 2.00, '00', 1, NULL),
	(983, 24, 2.00, '01', 1, NULL),
	(984, 24, 2.00, '02', 1, NULL),
	(985, 24, 2.00, '03', 1, NULL),
	(986, 24, 2.00, '04', 1, NULL),
	(987, 24, 2.00, '05', 1, NULL),
	(988, 24, 2.00, '10', 1, NULL),
	(989, 24, 2.00, '15', 1, NULL),
	(990, 24, 2.00, '20', 1, NULL),
	(991, 24, 2.00, '25', 1, NULL),
	(992, 24, 2.00, '30', 1, NULL),
	(993, 24, 2.00, '35', 1, NULL),
	(994, 24, 2.00, '40', 1, NULL),
	(995, 24, 2.00, '45', 1, NULL),
	(996, 24, 2.00, '50', 1, NULL),
	(997, 24, 2.00, '51', 1, NULL),
	(998, 24, 2.00, '52', 1, NULL),
	(999, 24, 2.00, '53', 1, NULL),
	(1000, 24, 2.00, '54', 1, NULL),
	(1001, 24, 2.00, '55', 1, NULL),
	(1002, 24, 3.00, '11', 2, NULL),
	(1003, 24, 3.00, '12', 2, NULL),
	(1004, 24, 3.00, '13', 2, NULL),
	(1005, 24, 3.00, '14', 2, NULL),
	(1006, 24, 3.00, '21', 2, NULL),
	(1007, 24, 3.00, '24', 2, NULL),
	(1008, 24, 3.00, '31', 2, NULL),
	(1009, 24, 3.00, '34', 2, NULL),
	(1010, 24, 3.00, '41', 2, NULL),
	(1011, 24, 3.00, '42', 2, NULL),
	(1012, 24, 3.00, '43', 2, NULL),
	(1013, 24, 3.00, '44', 2, NULL),
	(1014, 24, 4.00, '22', 3, NULL),
	(1015, 24, 4.00, '23', 3, NULL),
	(1016, 24, 4.00, '32', 3, NULL),
	(1017, 24, 4.00, '33', 3, NULL),
	(1045, 25, 2.00, '00', 1, NULL),
	(1046, 25, 2.00, '01', 1, NULL),
	(1047, 25, 2.00, '02', 1, NULL),
	(1048, 25, 2.00, '03', 1, NULL),
	(1049, 25, 2.00, '04', 1, NULL),
	(1050, 25, 2.00, '05', 1, NULL),
	(1051, 25, 2.00, '06', 1, NULL),
	(1052, 25, 2.00, '07', 1, NULL),
	(1053, 25, 2.00, '10', 1, NULL),
	(1054, 25, 2.00, '17', 1, NULL),
	(1055, 25, 2.00, '20', 1, NULL),
	(1056, 25, 2.00, '27', 1, NULL),
	(1057, 25, 2.00, '30', 1, NULL),
	(1058, 25, 2.00, '37', 1, NULL),
	(1059, 25, 2.00, '40', 1, NULL),
	(1060, 25, 2.00, '47', 1, NULL),
	(1061, 25, 2.00, '50', 1, NULL),
	(1062, 25, 2.00, '57', 1, NULL),
	(1063, 25, 2.00, '60', 1, NULL),
	(1064, 25, 2.00, '67', 1, NULL),
	(1065, 25, 2.00, '70', 1, NULL),
	(1066, 25, 2.00, '71', 1, NULL),
	(1067, 25, 2.00, '72', 1, NULL),
	(1068, 25, 2.00, '73', 1, NULL),
	(1069, 25, 2.00, '74', 1, NULL),
	(1070, 25, 2.00, '75', 1, NULL),
	(1071, 25, 2.00, '76', 1, NULL),
	(1072, 25, 2.00, '77', 1, NULL),
	(1073, 25, 3.00, '11', 2, NULL),
	(1074, 25, 3.00, '12', 2, NULL),
	(1075, 25, 3.00, '13', 2, NULL),
	(1076, 25, 3.00, '14', 2, NULL),
	(1077, 25, 3.00, '15', 2, NULL),
	(1078, 25, 3.00, '16', 2, NULL),
	(1079, 25, 3.00, '21', 2, NULL),
	(1080, 25, 3.00, '26', 2, NULL),
	(1081, 25, 3.00, '31', 2, NULL),
	(1082, 25, 3.00, '36', 2, NULL),
	(1083, 25, 3.00, '41', 2, NULL),
	(1084, 25, 3.00, '46', 2, NULL),
	(1085, 25, 3.00, '51', 2, NULL),
	(1086, 25, 3.00, '56', 2, NULL),
	(1087, 25, 3.00, '61', 2, NULL),
	(1088, 25, 3.00, '62', 2, NULL),
	(1089, 25, 3.00, '63', 2, NULL),
	(1090, 25, 3.00, '64', 2, NULL),
	(1091, 25, 3.00, '65', 2, NULL),
	(1092, 25, 3.00, '66', 2, NULL),
	(1093, 25, 4.00, '22', 3, NULL),
	(1094, 25, 4.00, '23', 3, NULL),
	(1095, 25, 4.00, '24', 3, NULL),
	(1096, 25, 4.00, '25', 3, NULL),
	(1097, 25, 4.00, '32', 3, NULL),
	(1098, 25, 4.00, '35', 3, NULL),
	(1099, 25, 4.00, '42', 3, NULL),
	(1100, 25, 4.00, '45', 3, NULL),
	(1101, 25, 4.00, '52', 3, NULL),
	(1102, 25, 4.00, '53', 3, NULL),
	(1103, 25, 4.00, '54', 3, NULL),
	(1104, 25, 4.00, '55', 3, NULL),
	(1105, 25, 5.00, '33', 4, NULL),
	(1106, 25, 5.00, '34', 4, NULL),
	(1107, 25, 5.00, '43', 4, NULL),
	(1108, 25, 5.00, '44', 4, NULL),
	(1172, 26, 2.00, '00', 1, NULL),
	(1173, 26, 2.00, '01', 1, NULL),
	(1174, 26, 2.00, '02', 1, NULL),
	(1175, 26, 2.00, '03', 1, NULL),
	(1176, 26, 2.00, '04', 1, NULL),
	(1177, 26, 2.00, '05', 1, NULL),
	(1178, 26, 2.00, '06', 1, NULL),
	(1179, 26, 2.00, '07', 1, NULL),
	(1180, 26, 2.00, '10', 1, NULL),
	(1181, 26, 2.00, '17', 1, NULL),
	(1182, 26, 2.00, '20', 1, NULL),
	(1183, 26, 2.00, '27', 1, NULL),
	(1184, 26, 2.00, '30', 1, NULL),
	(1185, 26, 2.00, '37', 1, NULL),
	(1186, 26, 2.00, '40', 1, NULL),
	(1187, 26, 2.00, '47', 1, NULL),
	(1188, 26, 2.00, '50', 1, NULL),
	(1189, 26, 2.00, '57', 1, NULL),
	(1190, 26, 2.00, '60', 1, NULL),
	(1191, 26, 2.00, '67', 1, NULL),
	(1192, 26, 2.00, '70', 1, NULL),
	(1193, 26, 2.00, '71', 1, NULL),
	(1194, 26, 2.00, '72', 1, NULL),
	(1195, 26, 2.00, '73', 1, NULL),
	(1196, 26, 2.00, '74', 1, NULL),
	(1197, 26, 2.00, '75', 1, NULL),
	(1198, 26, 2.00, '76', 1, NULL),
	(1199, 26, 2.00, '77', 1, NULL),
	(1200, 26, 3.00, '11', 2, NULL),
	(1201, 26, 3.00, '12', 2, NULL),
	(1202, 26, 3.00, '13', 2, NULL),
	(1203, 26, 3.00, '14', 2, NULL),
	(1204, 26, 3.00, '15', 2, NULL),
	(1205, 26, 3.00, '16', 2, NULL),
	(1206, 26, 3.00, '21', 2, NULL),
	(1207, 26, 3.00, '26', 2, NULL),
	(1208, 26, 3.00, '31', 2, NULL),
	(1209, 26, 3.00, '36', 2, NULL),
	(1210, 26, 3.00, '41', 2, NULL),
	(1211, 26, 3.00, '46', 2, NULL),
	(1212, 26, 3.00, '51', 2, NULL),
	(1213, 26, 3.00, '56', 2, NULL),
	(1214, 26, 3.00, '61', 2, NULL),
	(1215, 26, 3.00, '62', 2, NULL),
	(1216, 26, 3.00, '63', 2, NULL),
	(1217, 26, 3.00, '64', 2, NULL),
	(1218, 26, 3.00, '65', 2, NULL),
	(1219, 26, 3.00, '66', 2, NULL),
	(1220, 26, 4.00, '22', 3, NULL),
	(1221, 26, 4.00, '23', 3, NULL),
	(1222, 26, 4.00, '24', 3, NULL),
	(1223, 26, 4.00, '25', 3, NULL),
	(1224, 26, 4.00, '32', 3, NULL),
	(1225, 26, 4.00, '35', 3, NULL),
	(1226, 26, 4.00, '42', 3, NULL),
	(1227, 26, 4.00, '45', 3, NULL),
	(1228, 26, 4.00, '52', 3, NULL),
	(1229, 26, 4.00, '53', 3, NULL),
	(1230, 26, 4.00, '54', 3, NULL),
	(1231, 26, 4.00, '55', 3, NULL),
	(1232, 26, 5.00, '33', 4, NULL),
	(1233, 26, 5.00, '34', 4, NULL),
	(1234, 26, 5.00, '43', 4, NULL),
	(1235, 26, 5.00, '44', 4, NULL),
	(1299, 27, 2.00, '00', 1, NULL),
	(1300, 27, 2.00, '01', 1, NULL),
	(1301, 27, 2.00, '02', 1, NULL),
	(1302, 27, 2.00, '03', 1, NULL),
	(1303, 27, 2.00, '04', 1, NULL),
	(1304, 27, 2.00, '05', 1, NULL),
	(1305, 27, 2.00, '10', 1, NULL),
	(1306, 27, 2.00, '15', 1, NULL),
	(1307, 27, 2.00, '20', 1, NULL),
	(1308, 27, 2.00, '25', 1, NULL),
	(1309, 27, 2.00, '30', 1, NULL),
	(1310, 27, 2.00, '35', 1, NULL),
	(1311, 27, 2.00, '40', 1, NULL),
	(1312, 27, 2.00, '45', 1, NULL),
	(1313, 27, 2.00, '50', 1, NULL),
	(1314, 27, 2.00, '51', 1, NULL),
	(1315, 27, 2.00, '52', 1, NULL),
	(1316, 27, 2.00, '53', 1, NULL),
	(1317, 27, 2.00, '54', 1, NULL),
	(1318, 27, 2.00, '55', 1, NULL),
	(1319, 27, 3.00, '11', 2, NULL),
	(1320, 27, 3.00, '12', 2, NULL),
	(1321, 27, 3.00, '13', 2, NULL),
	(1322, 27, 3.00, '14', 2, NULL),
	(1323, 27, 3.00, '21', 2, NULL),
	(1324, 27, 3.00, '24', 2, NULL),
	(1325, 27, 3.00, '31', 2, NULL),
	(1326, 27, 3.00, '34', 2, NULL),
	(1327, 27, 3.00, '41', 2, NULL),
	(1328, 27, 3.00, '42', 2, NULL),
	(1329, 27, 3.00, '43', 2, NULL),
	(1330, 27, 3.00, '44', 2, NULL),
	(1331, 27, 4.00, '22', 3, NULL),
	(1332, 27, 4.00, '23', 3, NULL),
	(1333, 27, 4.00, '32', 3, NULL),
	(1334, 27, 4.00, '33', 3, NULL),
	(1362, 28, 2.00, '00', 1, NULL),
	(1363, 28, 2.00, '01', 1, NULL),
	(1364, 28, 2.00, '02', 1, NULL),
	(1365, 28, 2.00, '03', 1, NULL),
	(1366, 28, 2.00, '04', 1, NULL),
	(1367, 28, 2.00, '05', 1, NULL),
	(1368, 28, 2.00, '10', 1, NULL),
	(1369, 28, 2.00, '15', 1, NULL),
	(1370, 28, 2.00, '20', 1, NULL),
	(1371, 28, 2.00, '25', 1, NULL),
	(1372, 28, 2.00, '30', 1, NULL),
	(1373, 28, 2.00, '35', 1, NULL),
	(1374, 28, 2.00, '40', 1, NULL),
	(1375, 28, 2.00, '45', 1, NULL),
	(1376, 28, 2.00, '50', 1, NULL),
	(1377, 28, 2.00, '51', 1, NULL),
	(1378, 28, 2.00, '52', 1, NULL),
	(1379, 28, 2.00, '53', 1, NULL),
	(1380, 28, 2.00, '54', 1, NULL),
	(1381, 28, 2.00, '55', 1, NULL),
	(1382, 28, 3.00, '11', 2, NULL),
	(1383, 28, 3.00, '12', 2, NULL),
	(1384, 28, 3.00, '13', 2, NULL),
	(1385, 28, 3.00, '14', 2, NULL),
	(1386, 28, 3.00, '21', 2, NULL),
	(1387, 28, 3.00, '24', 2, NULL),
	(1388, 28, 3.00, '31', 2, NULL),
	(1389, 28, 3.00, '34', 2, NULL),
	(1390, 28, 3.00, '41', 2, NULL),
	(1391, 28, 3.00, '42', 2, NULL),
	(1392, 28, 3.00, '43', 2, NULL),
	(1393, 28, 3.00, '44', 2, NULL),
	(1394, 28, 4.00, '22', 3, NULL),
	(1395, 28, 4.00, '23', 3, NULL),
	(1396, 28, 4.00, '32', 3, NULL),
	(1397, 28, 4.00, '33', 3, NULL);
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
  `last_step_id` int(11) DEFAULT NULL,
  `game_status` char(1) DEFAULT NULL,
  PRIMARY KEY (`game_player_id`),
  KEY `FK_game_player_game` (`game_id`),
  KEY `FK_game_player_player` (`player_id`),
  KEY `FK_game_player_game_step` (`last_step_id`),
  CONSTRAINT `FK_game_player_game` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`),
  CONSTRAINT `FK_game_player_game_step` FOREIGN KEY (`last_step_id`) REFERENCES `game_step` (`game_step_id`),
  CONSTRAINT `FK_game_player_player` FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.game_player: ~8 rows (приблизительно)
DELETE FROM `game_player`;
/*!40000 ALTER TABLE `game_player` DISABLE KEYS */;
INSERT INTO `game_player` (`game_player_id`, `game_id`, `player_id`, `in_time`, `out_time`, `in_passiv_value`, `out_passiv_value`, `current_passiv_value`, `player_sym`, `order_connect`, `is_steping`, `is_active`, `start_steping`, `last_step_id`, `game_status`) VALUES
	(27, 21, 3, '2017-05-09 15:52:39', '2017-05-09 15:54:18', 567.00, -2633.00, 0.00, 'k1', 1, 1, 0, '2017-05-09 15:54:18', 53, 'L'),
	(28, 21, 4, '2017-05-09 15:52:39', '2017-05-09 17:32:01', 5000.00, 500.00, 0.00, 'a2', 2, 0, 0, '2017-05-09 15:54:17', 54, 'W'),
	(29, 22, 3, '2017-05-09 19:43:09', '2017-05-09 20:10:54', 678.00, 294678.00, 0.00, 'k1', 1, 1, 0, '2017-05-09 20:10:30', 103, 'R'),
	(30, 22, 4, '2017-05-09 19:43:09', '2017-05-09 20:39:17', 5000.00, 295100.00, 0.00, 'a2', 2, 0, 0, '2017-05-09 20:10:30', 104, 'R'),
	(31, 23, 3, '2017-05-09 20:14:34', '2017-05-09 20:17:54', 234.00, 39834.00, 0.00, 'k1', 1, 1, 0, '2017-05-09 20:17:09', 211, 'R'),
	(32, 23, 4, '2017-05-09 20:14:34', '2017-05-09 20:39:19', 5000.00, 1375200.00, 0.00, 'a2', 2, 0, 0, '2017-05-09 20:17:08', 212, 'R'),
	(33, 24, 3, '2017-05-09 20:39:54', '2017-05-09 20:40:53', 567.00, 57967.00, 0.00, 'k1', 1, 1, 0, '2017-05-09 20:40:42', 225, 'R'),
	(34, 24, 4, '2017-05-09 20:39:54', '2017-05-09 20:40:53', 5000.00, 13200.00, 0.00, 'a2', 2, 0, 0, '2017-05-09 20:40:41', 226, 'R'),
	(35, 25, 3, '2017-05-09 20:43:00', '2017-05-09 20:43:14', 567.00, -1433.00, 0.00, 'k1', 1, 0, 0, '2017-05-09 20:43:00', 227, 'L'),
	(36, 25, 4, '2017-05-09 20:43:00', '2017-05-09 20:43:14', 5000.00, 7400.00, 0.00, 'a2', 2, 1, 0, '2017-05-09 20:43:14', NULL, 'W'),
	(37, 26, 3, '2017-05-09 20:45:02', '2017-05-09 20:45:08', 567.00, -5433.00, 0.00, 'k1', 1, 0, 0, '2017-05-09 20:45:02', 229, 'L'),
	(38, 26, 4, '2017-05-09 20:45:02', '2017-05-09 20:45:09', 5000.00, 5000.00, 0.00, 'a2', 2, 1, 0, '2017-05-09 20:45:08', NULL, 'W'),
	(39, 27, 3, '2017-05-09 20:45:35', '2017-05-09 20:45:49', 567.00, -3033.00, 0.00, 'k1', 1, 0, 0, '2017-05-09 20:45:43', 233, 'L'),
	(40, 27, 4, '2017-05-09 20:45:35', '2017-05-09 20:45:49', 5000.00, 3600.00, 0.00, 'a2', 2, 1, 0, '2017-05-09 20:45:49', 232, 'W'),
	(41, 28, 3, '2017-05-09 20:45:56', '2017-05-09 20:46:13', 567.00, 11367.00, 0.00, 'k1', 1, 1, 0, '2017-05-09 20:46:09', 241, 'R'),
	(42, 28, 4, '2017-05-09 20:45:56', '2017-05-09 20:46:13', 5000.00, 14600.00, 0.00, 'a2', 2, 0, 0, '2017-05-09 20:46:08', 242, 'R');
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
) ENGINE=InnoDB AUTO_INCREMENT=1607 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы conjuncture.game_rate_hist: ~968 rows (приблизительно)
DELETE FROM `game_rate_hist`;
/*!40000 ALTER TABLE `game_rate_hist` DISABLE KEYS */;
INSERT INTO `game_rate_hist` (`game_rate_hist_id`, `game_id`, `game_player_id`, `game_step_id`, `field_type_id`, `fields_count`) VALUES
	(95, 21, NULL, 47, 1, 20),
	(96, 21, NULL, 47, 2, 12),
	(97, 21, NULL, 47, 3, 4),
	(98, 21, NULL, 48, 1, 20),
	(99, 21, NULL, 48, 2, 11),
	(100, 21, NULL, 48, 3, 4),
	(101, 21, 28, 48, 2, 1),
	(105, 21, NULL, 49, 1, 20),
	(106, 21, NULL, 49, 2, 11),
	(107, 21, NULL, 49, 3, 4),
	(108, 21, 28, 49, 2, 1),
	(112, 21, NULL, 50, 1, 19),
	(113, 21, NULL, 50, 2, 11),
	(114, 21, NULL, 50, 3, 4),
	(115, 21, 28, 50, 1, 1),
	(116, 21, 28, 50, 2, 1),
	(119, 21, NULL, 51, 1, 18),
	(120, 21, NULL, 51, 2, 11),
	(121, 21, NULL, 51, 3, 4),
	(122, 21, 27, 51, 1, 1),
	(123, 21, 28, 51, 1, 1),
	(124, 21, 28, 51, 2, 1),
	(126, 21, NULL, 52, 1, 17),
	(127, 21, NULL, 52, 2, 11),
	(128, 21, NULL, 52, 3, 4),
	(129, 21, 27, 52, 1, 1),
	(130, 21, 28, 52, 1, 2),
	(131, 21, 28, 52, 2, 1),
	(133, 21, NULL, 53, 1, 17),
	(134, 21, NULL, 53, 2, 8),
	(135, 21, NULL, 53, 3, 4),
	(136, 21, 27, 53, 1, 1),
	(137, 21, 27, 53, 2, 3),
	(138, 21, 28, 53, 1, 2),
	(139, 21, 28, 53, 2, 1),
	(140, 21, NULL, 54, 1, 16),
	(141, 21, NULL, 54, 2, 8),
	(142, 21, NULL, 54, 3, 4),
	(143, 21, 27, 54, 1, 1),
	(144, 21, 27, 54, 2, 3),
	(145, 21, 28, 54, 1, 3),
	(146, 21, 28, 54, 2, 1),
	(147, 22, NULL, 55, 1, 20),
	(148, 22, NULL, 55, 2, 12),
	(149, 22, NULL, 55, 3, 4),
	(150, 22, NULL, 56, 1, 20),
	(151, 22, NULL, 56, 2, 12),
	(152, 22, NULL, 56, 3, 3),
	(153, 22, 30, 56, 3, 1),
	(157, 22, NULL, 57, 1, 19),
	(158, 22, NULL, 57, 2, 10),
	(159, 22, NULL, 57, 3, 3),
	(160, 22, 29, 57, 1, 1),
	(161, 22, 29, 57, 2, 2),
	(162, 22, 30, 57, 3, 1),
	(164, 22, NULL, 58, 1, 19),
	(165, 22, NULL, 58, 2, 9),
	(166, 22, NULL, 58, 3, 3),
	(167, 22, 29, 58, 1, 1),
	(168, 22, 29, 58, 2, 2),
	(169, 22, 30, 58, 2, 1),
	(170, 22, 30, 58, 3, 1),
	(171, 22, NULL, 59, 1, 19),
	(172, 22, NULL, 59, 2, 11),
	(173, 22, NULL, 59, 3, 3),
	(174, 22, 29, 59, 1, 1),
	(175, 22, 30, 59, 2, 1),
	(176, 22, 30, 59, 3, 1),
	(178, 22, NULL, 60, 1, 18),
	(179, 22, NULL, 60, 2, 11),
	(180, 22, NULL, 60, 3, 3),
	(181, 22, 29, 60, 1, 1),
	(182, 22, 30, 60, 1, 1),
	(183, 22, 30, 60, 2, 1),
	(184, 22, 30, 60, 3, 1),
	(185, 22, NULL, 61, 1, 18),
	(186, 22, NULL, 61, 2, 11),
	(187, 22, 29, 61, 1, 1),
	(188, 22, 29, 61, 3, 3),
	(189, 22, 30, 61, 1, 1),
	(190, 22, 30, 61, 2, 1),
	(191, 22, 30, 61, 3, 1),
	(192, 22, NULL, 62, 1, 17),
	(193, 22, NULL, 62, 2, 11),
	(194, 22, 29, 62, 1, 1),
	(195, 22, 29, 62, 3, 3),
	(196, 22, 30, 62, 1, 2),
	(197, 22, 30, 62, 2, 1),
	(198, 22, 30, 62, 3, 1),
	(199, 22, NULL, 63, 1, 17),
	(200, 22, NULL, 63, 2, 10),
	(201, 22, 29, 63, 1, 1),
	(202, 22, 29, 63, 2, 1),
	(203, 22, 29, 63, 3, 3),
	(204, 22, 30, 63, 1, 2),
	(205, 22, 30, 63, 2, 1),
	(206, 22, 30, 63, 3, 1),
	(214, 22, NULL, 64, 1, 17),
	(215, 22, NULL, 64, 2, 9),
	(216, 22, 29, 64, 1, 1),
	(217, 22, 29, 64, 2, 1),
	(218, 22, 29, 64, 3, 3),
	(219, 22, 30, 64, 1, 2),
	(220, 22, 30, 64, 2, 2),
	(221, 22, 30, 64, 3, 1),
	(229, 22, NULL, 65, 1, 17),
	(230, 22, NULL, 65, 2, 9),
	(231, 22, 29, 65, 1, 1),
	(232, 22, 29, 65, 2, 1),
	(233, 22, 29, 65, 3, 3),
	(234, 22, 30, 65, 1, 2),
	(235, 22, 30, 65, 2, 2),
	(236, 22, 30, 65, 3, 1),
	(244, 22, NULL, 66, 1, 17),
	(245, 22, NULL, 66, 2, 8),
	(246, 22, 29, 66, 1, 1),
	(247, 22, 29, 66, 2, 1),
	(248, 22, 29, 66, 3, 3),
	(249, 22, 30, 66, 1, 2),
	(250, 22, 30, 66, 2, 3),
	(251, 22, 30, 66, 3, 1),
	(259, 22, NULL, 67, 1, 17),
	(260, 22, NULL, 67, 2, 8),
	(261, 22, 29, 67, 1, 1),
	(262, 22, 29, 67, 2, 1),
	(263, 22, 29, 67, 3, 3),
	(264, 22, 30, 67, 1, 2),
	(265, 22, 30, 67, 2, 3),
	(266, 22, 30, 67, 3, 1),
	(274, 22, NULL, 68, 1, 16),
	(275, 22, NULL, 68, 2, 8),
	(276, 22, 29, 68, 1, 1),
	(277, 22, 29, 68, 2, 1),
	(278, 22, 29, 68, 3, 3),
	(279, 22, 30, 68, 1, 3),
	(280, 22, 30, 68, 2, 3),
	(281, 22, 30, 68, 3, 1),
	(289, 22, NULL, 69, 1, 16),
	(290, 22, NULL, 69, 2, 8),
	(291, 22, 29, 69, 1, 1),
	(292, 22, 29, 69, 2, 1),
	(293, 22, 29, 69, 3, 3),
	(294, 22, 30, 69, 1, 3),
	(295, 22, 30, 69, 2, 3),
	(296, 22, 30, 69, 3, 1),
	(304, 22, NULL, 70, 1, 15),
	(305, 22, NULL, 70, 2, 8),
	(306, 22, 29, 70, 1, 1),
	(307, 22, 29, 70, 2, 1),
	(308, 22, 29, 70, 3, 3),
	(309, 22, 30, 70, 1, 4),
	(310, 22, 30, 70, 2, 3),
	(311, 22, 30, 70, 3, 1),
	(319, 22, NULL, 71, 1, 15),
	(320, 22, NULL, 71, 2, 8),
	(321, 22, 29, 71, 1, 1),
	(322, 22, 29, 71, 2, 1),
	(323, 22, 29, 71, 3, 3),
	(324, 22, 30, 71, 1, 4),
	(325, 22, 30, 71, 2, 3),
	(326, 22, 30, 71, 3, 1),
	(334, 22, NULL, 72, 1, 15),
	(335, 22, NULL, 72, 2, 7),
	(336, 22, 29, 72, 1, 1),
	(337, 22, 29, 72, 2, 1),
	(338, 22, 29, 72, 3, 3),
	(339, 22, 30, 72, 1, 4),
	(340, 22, 30, 72, 2, 4),
	(341, 22, 30, 72, 3, 1),
	(349, 22, NULL, 73, 1, 15),
	(350, 22, NULL, 73, 2, 7),
	(351, 22, 29, 73, 1, 1),
	(352, 22, 29, 73, 2, 1),
	(353, 22, 29, 73, 3, 3),
	(354, 22, 30, 73, 1, 4),
	(355, 22, 30, 73, 2, 4),
	(356, 22, 30, 73, 3, 1),
	(364, 22, NULL, 74, 1, 15),
	(365, 22, NULL, 74, 2, 6),
	(366, 22, 29, 74, 1, 1),
	(367, 22, 29, 74, 2, 1),
	(368, 22, 29, 74, 3, 3),
	(369, 22, 30, 74, 1, 4),
	(370, 22, 30, 74, 2, 5),
	(371, 22, 30, 74, 3, 1),
	(379, 22, NULL, 75, 1, 15),
	(380, 22, NULL, 75, 2, 6),
	(381, 22, 29, 75, 1, 1),
	(382, 22, 29, 75, 2, 1),
	(383, 22, 29, 75, 3, 3),
	(384, 22, 30, 75, 1, 4),
	(385, 22, 30, 75, 2, 5),
	(386, 22, 30, 75, 3, 1),
	(394, 22, NULL, 76, 1, 14),
	(395, 22, NULL, 76, 2, 6),
	(396, 22, 29, 76, 1, 1),
	(397, 22, 29, 76, 2, 1),
	(398, 22, 29, 76, 3, 3),
	(399, 22, 30, 76, 1, 5),
	(400, 22, 30, 76, 2, 5),
	(401, 22, 30, 76, 3, 1),
	(409, 22, NULL, 77, 1, 14),
	(410, 22, NULL, 77, 2, 6),
	(411, 22, 29, 77, 1, 1),
	(412, 22, 29, 77, 2, 1),
	(413, 22, 29, 77, 3, 3),
	(414, 22, 30, 77, 1, 5),
	(415, 22, 30, 77, 2, 5),
	(416, 22, 30, 77, 3, 1),
	(424, 22, NULL, 78, 1, 13),
	(425, 22, NULL, 78, 2, 6),
	(426, 22, 29, 78, 1, 1),
	(427, 22, 29, 78, 2, 1),
	(428, 22, 29, 78, 3, 3),
	(429, 22, 30, 78, 1, 6),
	(430, 22, 30, 78, 2, 5),
	(431, 22, 30, 78, 3, 1),
	(439, 22, NULL, 79, 1, 13),
	(440, 22, NULL, 79, 2, 6),
	(441, 22, 29, 79, 1, 1),
	(442, 22, 29, 79, 2, 1),
	(443, 22, 29, 79, 3, 3),
	(444, 22, 30, 79, 1, 6),
	(445, 22, 30, 79, 2, 5),
	(446, 22, 30, 79, 3, 1),
	(454, 22, NULL, 80, 1, 13),
	(455, 22, NULL, 80, 2, 5),
	(456, 22, 29, 80, 1, 1),
	(457, 22, 29, 80, 2, 1),
	(458, 22, 29, 80, 3, 3),
	(459, 22, 30, 80, 1, 6),
	(460, 22, 30, 80, 2, 6),
	(461, 22, 30, 80, 3, 1),
	(469, 22, NULL, 81, 1, 13),
	(470, 22, NULL, 81, 2, 5),
	(471, 22, 29, 81, 1, 1),
	(472, 22, 29, 81, 2, 1),
	(473, 22, 29, 81, 3, 3),
	(474, 22, 30, 81, 1, 6),
	(475, 22, 30, 81, 2, 6),
	(476, 22, 30, 81, 3, 1),
	(484, 22, NULL, 82, 1, 12),
	(485, 22, NULL, 82, 2, 5),
	(486, 22, 29, 82, 1, 1),
	(487, 22, 29, 82, 2, 1),
	(488, 22, 29, 82, 3, 3),
	(489, 22, 30, 82, 1, 7),
	(490, 22, 30, 82, 2, 6),
	(491, 22, 30, 82, 3, 1),
	(499, 22, NULL, 83, 1, 12),
	(500, 22, NULL, 83, 2, 5),
	(501, 22, 29, 83, 1, 1),
	(502, 22, 29, 83, 2, 1),
	(503, 22, 29, 83, 3, 3),
	(504, 22, 30, 83, 1, 7),
	(505, 22, 30, 83, 2, 6),
	(506, 22, 30, 83, 3, 1),
	(514, 22, NULL, 84, 1, 11),
	(515, 22, NULL, 84, 2, 5),
	(516, 22, 29, 84, 1, 1),
	(517, 22, 29, 84, 2, 1),
	(518, 22, 29, 84, 3, 3),
	(519, 22, 30, 84, 1, 8),
	(520, 22, 30, 84, 2, 6),
	(521, 22, 30, 84, 3, 1),
	(529, 22, NULL, 85, 1, 11),
	(530, 22, NULL, 85, 2, 5),
	(531, 22, 29, 85, 1, 1),
	(532, 22, 29, 85, 2, 1),
	(533, 22, 29, 85, 3, 3),
	(534, 22, 30, 85, 1, 8),
	(535, 22, 30, 85, 2, 6),
	(536, 22, 30, 85, 3, 1),
	(544, 22, NULL, 86, 1, 10),
	(545, 22, NULL, 86, 2, 5),
	(546, 22, 29, 86, 1, 1),
	(547, 22, 29, 86, 2, 1),
	(548, 22, 29, 86, 3, 3),
	(549, 22, 30, 86, 1, 9),
	(550, 22, 30, 86, 2, 6),
	(551, 22, 30, 86, 3, 1),
	(559, 22, NULL, 87, 1, 10),
	(560, 22, NULL, 87, 2, 5),
	(561, 22, 29, 87, 1, 1),
	(562, 22, 29, 87, 2, 1),
	(563, 22, 29, 87, 3, 3),
	(564, 22, 30, 87, 1, 9),
	(565, 22, 30, 87, 2, 6),
	(566, 22, 30, 87, 3, 1),
	(574, 22, NULL, 88, 1, 10),
	(575, 22, NULL, 88, 2, 4),
	(576, 22, 29, 88, 1, 1),
	(577, 22, 29, 88, 2, 1),
	(578, 22, 29, 88, 3, 3),
	(579, 22, 30, 88, 1, 9),
	(580, 22, 30, 88, 2, 7),
	(581, 22, 30, 88, 3, 1),
	(589, 22, NULL, 89, 2, 1),
	(590, 22, 29, 89, 1, 11),
	(591, 22, 29, 89, 2, 4),
	(592, 22, 29, 89, 3, 3),
	(593, 22, 30, 89, 1, 9),
	(594, 22, 30, 89, 2, 7),
	(595, 22, 30, 89, 3, 1),
	(596, 22, 29, 90, 1, 11),
	(597, 22, 29, 90, 2, 4),
	(598, 22, 29, 90, 3, 3),
	(599, 22, 30, 90, 1, 9),
	(600, 22, 30, 90, 2, 8),
	(601, 22, 30, 90, 3, 1),
	(603, 22, 29, 91, 1, 11),
	(604, 22, 29, 91, 2, 4),
	(605, 22, 29, 91, 3, 3),
	(606, 22, 30, 91, 1, 9),
	(607, 22, 30, 91, 2, 8),
	(608, 22, 30, 91, 3, 1),
	(610, 22, 29, 92, 1, 11),
	(611, 22, 29, 92, 2, 4),
	(612, 22, 29, 92, 3, 3),
	(613, 22, 30, 92, 1, 9),
	(614, 22, 30, 92, 2, 8),
	(615, 22, 30, 92, 3, 1),
	(617, 22, 29, 93, 1, 11),
	(618, 22, 29, 93, 2, 4),
	(619, 22, 29, 93, 3, 3),
	(620, 22, 30, 93, 1, 9),
	(621, 22, 30, 93, 2, 8),
	(622, 22, 30, 93, 3, 1),
	(624, 22, 29, 94, 1, 11),
	(625, 22, 29, 94, 2, 4),
	(626, 22, 29, 94, 3, 3),
	(627, 22, 30, 94, 1, 9),
	(628, 22, 30, 94, 2, 8),
	(629, 22, 30, 94, 3, 1),
	(631, 22, 29, 95, 1, 11),
	(632, 22, 29, 95, 2, 4),
	(633, 22, 29, 95, 3, 3),
	(634, 22, 30, 95, 1, 9),
	(635, 22, 30, 95, 2, 8),
	(636, 22, 30, 95, 3, 1),
	(638, 22, 29, 96, 1, 11),
	(639, 22, 29, 96, 2, 4),
	(640, 22, 29, 96, 3, 3),
	(641, 22, 30, 96, 1, 9),
	(642, 22, 30, 96, 2, 8),
	(643, 22, 30, 96, 3, 1),
	(645, 22, 29, 97, 1, 11),
	(646, 22, 29, 97, 2, 4),
	(647, 22, 29, 97, 3, 3),
	(648, 22, 30, 97, 1, 9),
	(649, 22, 30, 97, 2, 8),
	(650, 22, 30, 97, 3, 1),
	(652, 22, 29, 98, 1, 11),
	(653, 22, 29, 98, 2, 4),
	(654, 22, 29, 98, 3, 3),
	(655, 22, 30, 98, 1, 9),
	(656, 22, 30, 98, 2, 8),
	(657, 22, 30, 98, 3, 1),
	(659, 22, NULL, 99, 3, 3),
	(660, 22, 29, 99, 1, 11),
	(661, 22, 29, 99, 2, 4),
	(662, 22, 30, 99, 1, 9),
	(663, 22, 30, 99, 2, 8),
	(664, 22, 30, 99, 3, 1),
	(666, 22, NULL, 100, 3, 2),
	(667, 22, 29, 100, 1, 11),
	(668, 22, 29, 100, 2, 4),
	(669, 22, 30, 100, 1, 9),
	(670, 22, 30, 100, 2, 8),
	(671, 22, 30, 100, 3, 2),
	(673, 22, NULL, 101, 1, 4),
	(674, 22, NULL, 101, 3, 2),
	(675, 22, 29, 101, 1, 7),
	(676, 22, 29, 101, 2, 4),
	(677, 22, 30, 101, 1, 9),
	(678, 22, 30, 101, 2, 8),
	(679, 22, 30, 101, 3, 2),
	(680, 22, NULL, 102, 1, 4),
	(681, 22, NULL, 102, 3, 1),
	(682, 22, 29, 102, 1, 7),
	(683, 22, 29, 102, 2, 4),
	(684, 22, 30, 102, 1, 9),
	(685, 22, 30, 102, 2, 8),
	(686, 22, 30, 102, 3, 3),
	(687, 22, NULL, 103, 1, 4),
	(688, 22, NULL, 103, 3, 1),
	(689, 22, 29, 103, 1, 7),
	(690, 22, 29, 103, 2, 4),
	(691, 22, 30, 103, 1, 9),
	(692, 22, 30, 103, 2, 8),
	(693, 22, 30, 103, 3, 3),
	(694, 22, NULL, 104, 1, 3),
	(695, 22, NULL, 104, 3, 1),
	(696, 22, 29, 104, 1, 7),
	(697, 22, 29, 104, 2, 4),
	(698, 22, 30, 104, 1, 10),
	(699, 22, 30, 104, 2, 8),
	(700, 22, 30, 104, 3, 3),
	(701, 23, NULL, 105, 1, 18),
	(702, 23, NULL, 105, 2, 12),
	(703, 23, NULL, 105, 3, 4),
	(704, 23, 31, 105, 1, 2),
	(708, 23, NULL, 106, 1, 18),
	(709, 23, NULL, 106, 2, 11),
	(710, 23, NULL, 106, 3, 4),
	(711, 23, 31, 106, 1, 2),
	(712, 23, 32, 106, 2, 1),
	(715, 23, NULL, 107, 1, 18),
	(716, 23, NULL, 107, 2, 11),
	(717, 23, NULL, 107, 3, 4),
	(718, 23, 31, 107, 1, 2),
	(719, 23, 32, 107, 2, 1),
	(722, 23, NULL, 108, 1, 18),
	(723, 23, NULL, 108, 2, 10),
	(724, 23, NULL, 108, 3, 4),
	(725, 23, 31, 108, 1, 2),
	(726, 23, 32, 108, 2, 2),
	(729, 23, NULL, 109, 1, 18),
	(730, 23, NULL, 109, 2, 10),
	(731, 23, NULL, 109, 3, 4),
	(732, 23, 31, 109, 1, 2),
	(733, 23, 32, 109, 2, 2),
	(736, 23, NULL, 110, 1, 18),
	(737, 23, NULL, 110, 2, 9),
	(738, 23, NULL, 110, 3, 4),
	(739, 23, 31, 110, 1, 2),
	(740, 23, 32, 110, 2, 3),
	(743, 23, NULL, 111, 1, 18),
	(744, 23, NULL, 111, 2, 9),
	(745, 23, NULL, 111, 3, 4),
	(746, 23, 31, 111, 1, 2),
	(747, 23, 32, 111, 2, 3),
	(750, 23, NULL, 112, 1, 18),
	(751, 23, NULL, 112, 2, 8),
	(752, 23, NULL, 112, 3, 4),
	(753, 23, 31, 112, 1, 2),
	(754, 23, 32, 112, 2, 4),
	(757, 23, NULL, 113, 1, 18),
	(758, 23, NULL, 113, 2, 8),
	(759, 23, NULL, 113, 3, 4),
	(760, 23, 31, 113, 1, 2),
	(761, 23, 32, 113, 2, 4),
	(764, 23, NULL, 114, 1, 18),
	(765, 23, NULL, 114, 2, 8),
	(766, 23, NULL, 114, 3, 3),
	(767, 23, 31, 114, 1, 2),
	(768, 23, 32, 114, 2, 4),
	(769, 23, 32, 114, 3, 1),
	(771, 23, NULL, 115, 1, 18),
	(772, 23, NULL, 115, 2, 8),
	(773, 23, NULL, 115, 3, 3),
	(774, 23, 31, 115, 1, 2),
	(775, 23, 32, 115, 2, 4),
	(776, 23, 32, 115, 3, 1),
	(778, 23, NULL, 116, 1, 17),
	(779, 23, NULL, 116, 2, 8),
	(780, 23, NULL, 116, 3, 3),
	(781, 23, 31, 116, 1, 2),
	(782, 23, 32, 116, 1, 1),
	(783, 23, 32, 116, 2, 4),
	(784, 23, 32, 116, 3, 1),
	(785, 23, NULL, 117, 1, 17),
	(786, 23, NULL, 117, 2, 8),
	(787, 23, NULL, 117, 3, 3),
	(788, 23, 31, 117, 1, 2),
	(789, 23, 32, 117, 1, 1),
	(790, 23, 32, 117, 2, 4),
	(791, 23, 32, 117, 3, 1),
	(792, 23, NULL, 118, 1, 17),
	(793, 23, NULL, 118, 2, 7),
	(794, 23, NULL, 118, 3, 3),
	(795, 23, 31, 118, 1, 2),
	(796, 23, 32, 118, 1, 1),
	(797, 23, 32, 118, 2, 5),
	(798, 23, 32, 118, 3, 1),
	(799, 23, NULL, 119, 1, 17),
	(800, 23, NULL, 119, 2, 7),
	(801, 23, NULL, 119, 3, 3),
	(802, 23, 31, 119, 1, 2),
	(803, 23, 32, 119, 1, 1),
	(804, 23, 32, 119, 2, 5),
	(805, 23, 32, 119, 3, 1),
	(806, 23, NULL, 120, 1, 16),
	(807, 23, NULL, 120, 2, 7),
	(808, 23, NULL, 120, 3, 3),
	(809, 23, 31, 120, 1, 2),
	(810, 23, 32, 120, 1, 2),
	(811, 23, 32, 120, 2, 5),
	(812, 23, 32, 120, 3, 1),
	(813, 23, NULL, 121, 1, 16),
	(814, 23, NULL, 121, 2, 7),
	(815, 23, NULL, 121, 3, 3),
	(816, 23, 31, 121, 1, 2),
	(817, 23, 32, 121, 1, 2),
	(818, 23, 32, 121, 2, 5),
	(819, 23, 32, 121, 3, 1),
	(820, 23, NULL, 122, 1, 16),
	(821, 23, NULL, 122, 2, 6),
	(822, 23, NULL, 122, 3, 3),
	(823, 23, 31, 122, 1, 2),
	(824, 23, 32, 122, 1, 2),
	(825, 23, 32, 122, 2, 6),
	(826, 23, 32, 122, 3, 1),
	(827, 23, NULL, 123, 1, 16),
	(828, 23, NULL, 123, 2, 6),
	(829, 23, NULL, 123, 3, 3),
	(830, 23, 31, 123, 1, 2),
	(831, 23, 32, 123, 1, 2),
	(832, 23, 32, 123, 2, 6),
	(833, 23, 32, 123, 3, 1),
	(834, 23, NULL, 124, 1, 16),
	(835, 23, NULL, 124, 2, 5),
	(836, 23, NULL, 124, 3, 3),
	(837, 23, 31, 124, 1, 2),
	(838, 23, 32, 124, 1, 2),
	(839, 23, 32, 124, 2, 7),
	(840, 23, 32, 124, 3, 1),
	(841, 23, NULL, 125, 1, 16),
	(842, 23, NULL, 125, 2, 5),
	(843, 23, NULL, 125, 3, 3),
	(844, 23, 31, 125, 1, 2),
	(845, 23, 32, 125, 1, 2),
	(846, 23, 32, 125, 2, 7),
	(847, 23, 32, 125, 3, 1),
	(848, 23, NULL, 126, 1, 16),
	(849, 23, NULL, 126, 2, 4),
	(850, 23, NULL, 126, 3, 3),
	(851, 23, 31, 126, 1, 2),
	(852, 23, 32, 126, 1, 2),
	(853, 23, 32, 126, 2, 8),
	(854, 23, 32, 126, 3, 1),
	(855, 23, NULL, 127, 1, 16),
	(856, 23, NULL, 127, 2, 4),
	(857, 23, NULL, 127, 3, 3),
	(858, 23, 31, 127, 1, 2),
	(859, 23, 32, 127, 1, 2),
	(860, 23, 32, 127, 2, 8),
	(861, 23, 32, 127, 3, 1),
	(862, 23, NULL, 128, 1, 15),
	(863, 23, NULL, 128, 2, 4),
	(864, 23, NULL, 128, 3, 3),
	(865, 23, 31, 128, 1, 2),
	(866, 23, 32, 128, 1, 3),
	(867, 23, 32, 128, 2, 8),
	(868, 23, 32, 128, 3, 1),
	(869, 23, NULL, 129, 1, 15),
	(870, 23, NULL, 129, 2, 4),
	(871, 23, NULL, 129, 3, 3),
	(872, 23, 31, 129, 1, 2),
	(873, 23, 32, 129, 1, 3),
	(874, 23, 32, 129, 2, 8),
	(875, 23, 32, 129, 3, 1),
	(876, 23, NULL, 130, 1, 15),
	(877, 23, NULL, 130, 2, 3),
	(878, 23, NULL, 130, 3, 3),
	(879, 23, 31, 130, 1, 2),
	(880, 23, 32, 130, 1, 3),
	(881, 23, 32, 130, 2, 9),
	(882, 23, 32, 130, 3, 1),
	(883, 23, NULL, 131, 1, 15),
	(884, 23, NULL, 131, 2, 3),
	(885, 23, NULL, 131, 3, 3),
	(886, 23, 31, 131, 1, 2),
	(887, 23, 32, 131, 1, 3),
	(888, 23, 32, 131, 2, 9),
	(889, 23, 32, 131, 3, 1),
	(890, 23, NULL, 132, 1, 15),
	(891, 23, NULL, 132, 2, 3),
	(892, 23, NULL, 132, 3, 2),
	(893, 23, 31, 132, 1, 2),
	(894, 23, 32, 132, 1, 3),
	(895, 23, 32, 132, 2, 9),
	(896, 23, 32, 132, 3, 2),
	(897, 23, NULL, 133, 1, 15),
	(898, 23, NULL, 133, 2, 3),
	(899, 23, NULL, 133, 3, 2),
	(900, 23, 31, 133, 1, 2),
	(901, 23, 32, 133, 1, 3),
	(902, 23, 32, 133, 2, 9),
	(903, 23, 32, 133, 3, 2),
	(904, 23, NULL, 134, 1, 14),
	(905, 23, NULL, 134, 2, 3),
	(906, 23, NULL, 134, 3, 2),
	(907, 23, 31, 134, 1, 2),
	(908, 23, 32, 134, 1, 4),
	(909, 23, 32, 134, 2, 9),
	(910, 23, 32, 134, 3, 2),
	(911, 23, NULL, 135, 1, 14),
	(912, 23, NULL, 135, 2, 3),
	(913, 23, NULL, 135, 3, 2),
	(914, 23, 31, 135, 1, 2),
	(915, 23, 32, 135, 1, 4),
	(916, 23, 32, 135, 2, 9),
	(917, 23, 32, 135, 3, 2),
	(918, 23, NULL, 136, 1, 14),
	(919, 23, NULL, 136, 2, 2),
	(920, 23, NULL, 136, 3, 2),
	(921, 23, 31, 136, 1, 2),
	(922, 23, 32, 136, 1, 4),
	(923, 23, 32, 136, 2, 10),
	(924, 23, 32, 136, 3, 2),
	(925, 23, NULL, 137, 1, 14),
	(926, 23, NULL, 137, 2, 2),
	(927, 23, NULL, 137, 3, 2),
	(928, 23, 31, 137, 1, 2),
	(929, 23, 32, 137, 1, 4),
	(930, 23, 32, 137, 2, 10),
	(931, 23, 32, 137, 3, 2),
	(932, 23, NULL, 138, 1, 13),
	(933, 23, NULL, 138, 2, 2),
	(934, 23, NULL, 138, 3, 2),
	(935, 23, 31, 138, 1, 2),
	(936, 23, 32, 138, 1, 5),
	(937, 23, 32, 138, 2, 10),
	(938, 23, 32, 138, 3, 2),
	(939, 23, NULL, 139, 1, 13),
	(940, 23, NULL, 139, 2, 2),
	(941, 23, NULL, 139, 3, 2),
	(942, 23, 31, 139, 1, 2),
	(943, 23, 32, 139, 1, 5),
	(944, 23, 32, 139, 2, 10),
	(945, 23, 32, 139, 3, 2),
	(946, 23, NULL, 140, 1, 12),
	(947, 23, NULL, 140, 2, 2),
	(948, 23, NULL, 140, 3, 2),
	(949, 23, 31, 140, 1, 2),
	(950, 23, 32, 140, 1, 6),
	(951, 23, 32, 140, 2, 10),
	(952, 23, 32, 140, 3, 2),
	(953, 23, NULL, 141, 1, 12),
	(954, 23, NULL, 141, 2, 2),
	(955, 23, NULL, 141, 3, 2),
	(956, 23, 31, 141, 1, 2),
	(957, 23, 32, 141, 1, 6),
	(958, 23, 32, 141, 2, 10),
	(959, 23, 32, 141, 3, 2),
	(960, 23, NULL, 142, 1, 11),
	(961, 23, NULL, 142, 2, 2),
	(962, 23, NULL, 142, 3, 2),
	(963, 23, 31, 142, 1, 2),
	(964, 23, 32, 142, 1, 7),
	(965, 23, 32, 142, 2, 10),
	(966, 23, 32, 142, 3, 2),
	(967, 23, NULL, 143, 1, 11),
	(968, 23, NULL, 143, 2, 2),
	(969, 23, NULL, 143, 3, 2),
	(970, 23, 31, 143, 1, 2),
	(971, 23, 32, 143, 1, 7),
	(972, 23, 32, 143, 2, 10),
	(973, 23, 32, 143, 3, 2),
	(974, 23, NULL, 144, 1, 11),
	(975, 23, NULL, 144, 2, 1),
	(976, 23, NULL, 144, 3, 2),
	(977, 23, 31, 144, 1, 2),
	(978, 23, 32, 144, 1, 7),
	(979, 23, 32, 144, 2, 11),
	(980, 23, 32, 144, 3, 2),
	(981, 23, NULL, 145, 1, 11),
	(982, 23, NULL, 145, 2, 1),
	(983, 23, NULL, 145, 3, 2),
	(984, 23, 31, 145, 1, 2),
	(985, 23, 32, 145, 1, 7),
	(986, 23, 32, 145, 2, 11),
	(987, 23, 32, 145, 3, 2),
	(988, 23, NULL, 146, 1, 11),
	(989, 23, NULL, 146, 2, 1),
	(990, 23, NULL, 146, 3, 1),
	(991, 23, 31, 146, 1, 2),
	(992, 23, 32, 146, 1, 7),
	(993, 23, 32, 146, 2, 11),
	(994, 23, 32, 146, 3, 3),
	(995, 23, NULL, 147, 1, 11),
	(996, 23, NULL, 147, 2, 1),
	(997, 23, NULL, 147, 3, 1),
	(998, 23, 31, 147, 1, 2),
	(999, 23, 32, 147, 1, 7),
	(1000, 23, 32, 147, 2, 11),
	(1001, 23, 32, 147, 3, 3),
	(1002, 23, NULL, 148, 1, 10),
	(1003, 23, NULL, 148, 2, 1),
	(1004, 23, NULL, 148, 3, 1),
	(1005, 23, 31, 148, 1, 2),
	(1006, 23, 32, 148, 1, 8),
	(1007, 23, 32, 148, 2, 11),
	(1008, 23, 32, 148, 3, 3),
	(1009, 23, NULL, 149, 1, 10),
	(1010, 23, NULL, 149, 2, 1),
	(1011, 23, NULL, 149, 3, 1),
	(1012, 23, 31, 149, 1, 2),
	(1013, 23, 32, 149, 1, 8),
	(1014, 23, 32, 149, 2, 11),
	(1015, 23, 32, 149, 3, 3),
	(1016, 23, NULL, 150, 1, 9),
	(1017, 23, NULL, 150, 2, 1),
	(1018, 23, NULL, 150, 3, 1),
	(1019, 23, 31, 150, 1, 2),
	(1020, 23, 32, 150, 1, 9),
	(1021, 23, 32, 150, 2, 11),
	(1022, 23, 32, 150, 3, 3),
	(1023, 23, NULL, 151, 1, 9),
	(1024, 23, NULL, 151, 2, 1),
	(1025, 23, NULL, 151, 3, 1),
	(1026, 23, 31, 151, 1, 2),
	(1027, 23, 32, 151, 1, 9),
	(1028, 23, 32, 151, 2, 11),
	(1029, 23, 32, 151, 3, 3),
	(1030, 23, NULL, 152, 1, 9),
	(1031, 23, NULL, 152, 3, 1),
	(1032, 23, 31, 152, 1, 2),
	(1033, 23, 32, 152, 1, 9),
	(1034, 23, 32, 152, 2, 12),
	(1035, 23, 32, 152, 3, 3),
	(1037, 23, NULL, 153, 1, 9),
	(1038, 23, NULL, 153, 3, 1),
	(1039, 23, 31, 153, 1, 2),
	(1040, 23, 32, 153, 1, 9),
	(1041, 23, 32, 153, 2, 12),
	(1042, 23, 32, 153, 3, 3),
	(1044, 23, NULL, 154, 1, 8),
	(1045, 23, NULL, 154, 3, 1),
	(1046, 23, 31, 154, 1, 2),
	(1047, 23, 32, 154, 1, 10),
	(1048, 23, 32, 154, 2, 12),
	(1049, 23, 32, 154, 3, 3),
	(1051, 23, NULL, 155, 1, 8),
	(1052, 23, NULL, 155, 3, 1),
	(1053, 23, 31, 155, 1, 2),
	(1054, 23, 32, 155, 1, 10),
	(1055, 23, 32, 155, 2, 12),
	(1056, 23, 32, 155, 3, 3),
	(1058, 23, NULL, 156, 1, 7),
	(1059, 23, NULL, 156, 3, 1),
	(1060, 23, 31, 156, 1, 2),
	(1061, 23, 32, 156, 1, 11),
	(1062, 23, 32, 156, 2, 12),
	(1063, 23, 32, 156, 3, 3),
	(1065, 23, NULL, 157, 1, 7),
	(1066, 23, NULL, 157, 3, 1),
	(1067, 23, 31, 157, 1, 2),
	(1068, 23, 32, 157, 1, 11),
	(1069, 23, 32, 157, 2, 12),
	(1070, 23, 32, 157, 3, 3),
	(1072, 23, NULL, 158, 1, 6),
	(1073, 23, NULL, 158, 3, 1),
	(1074, 23, 31, 158, 1, 2),
	(1075, 23, 32, 158, 1, 12),
	(1076, 23, 32, 158, 2, 12),
	(1077, 23, 32, 158, 3, 3),
	(1079, 23, NULL, 159, 1, 6),
	(1080, 23, NULL, 159, 3, 1),
	(1081, 23, 31, 159, 1, 2),
	(1082, 23, 32, 159, 1, 12),
	(1083, 23, 32, 159, 2, 12),
	(1084, 23, 32, 159, 3, 3),
	(1086, 23, NULL, 160, 1, 5),
	(1087, 23, NULL, 160, 3, 1),
	(1088, 23, 31, 160, 1, 2),
	(1089, 23, 32, 160, 1, 13),
	(1090, 23, 32, 160, 2, 12),
	(1091, 23, 32, 160, 3, 3),
	(1093, 23, NULL, 161, 1, 5),
	(1094, 23, NULL, 161, 3, 1),
	(1095, 23, 31, 161, 1, 2),
	(1096, 23, 32, 161, 1, 13),
	(1097, 23, 32, 161, 2, 12),
	(1098, 23, 32, 161, 3, 3),
	(1100, 23, NULL, 162, 1, 4),
	(1101, 23, NULL, 162, 3, 1),
	(1102, 23, 31, 162, 1, 2),
	(1103, 23, 32, 162, 1, 14),
	(1104, 23, 32, 162, 2, 12),
	(1105, 23, 32, 162, 3, 3),
	(1107, 23, NULL, 163, 1, 4),
	(1108, 23, NULL, 163, 3, 1),
	(1109, 23, 31, 163, 1, 2),
	(1110, 23, 32, 163, 1, 14),
	(1111, 23, 32, 163, 2, 12),
	(1112, 23, 32, 163, 3, 3),
	(1114, 23, NULL, 164, 1, 3),
	(1115, 23, NULL, 164, 3, 1),
	(1116, 23, 31, 164, 1, 2),
	(1117, 23, 32, 164, 1, 15),
	(1118, 23, 32, 164, 2, 12),
	(1119, 23, 32, 164, 3, 3),
	(1121, 23, NULL, 165, 1, 3),
	(1122, 23, NULL, 165, 3, 1),
	(1123, 23, 31, 165, 1, 2),
	(1124, 23, 32, 165, 1, 15),
	(1125, 23, 32, 165, 2, 12),
	(1126, 23, 32, 165, 3, 3),
	(1128, 23, NULL, 166, 1, 3),
	(1129, 23, 31, 166, 1, 2),
	(1130, 23, 32, 166, 1, 15),
	(1131, 23, 32, 166, 2, 12),
	(1132, 23, 32, 166, 3, 4),
	(1135, 23, NULL, 167, 1, 3),
	(1136, 23, 31, 167, 1, 2),
	(1137, 23, 32, 167, 1, 15),
	(1138, 23, 32, 167, 2, 12),
	(1139, 23, 32, 167, 3, 4),
	(1142, 23, NULL, 168, 1, 2),
	(1143, 23, 31, 168, 1, 2),
	(1144, 23, 32, 168, 1, 16),
	(1145, 23, 32, 168, 2, 12),
	(1146, 23, 32, 168, 3, 4),
	(1149, 23, NULL, 169, 1, 2),
	(1150, 23, 31, 169, 1, 2),
	(1151, 23, 32, 169, 1, 16),
	(1152, 23, 32, 169, 2, 12),
	(1153, 23, 32, 169, 3, 4),
	(1156, 23, NULL, 170, 1, 1),
	(1157, 23, 31, 170, 1, 2),
	(1158, 23, 32, 170, 1, 17),
	(1159, 23, 32, 170, 2, 12),
	(1160, 23, 32, 170, 3, 4),
	(1163, 23, NULL, 171, 1, 1),
	(1164, 23, 31, 171, 1, 2),
	(1165, 23, 32, 171, 1, 17),
	(1166, 23, 32, 171, 2, 12),
	(1167, 23, 32, 171, 3, 4),
	(1170, 23, 31, 172, 1, 2),
	(1171, 23, 32, 172, 1, 18),
	(1172, 23, 32, 172, 2, 12),
	(1173, 23, 32, 172, 3, 4),
	(1177, 23, 31, 173, 1, 2),
	(1178, 23, 32, 173, 1, 18),
	(1179, 23, 32, 173, 2, 12),
	(1180, 23, 32, 173, 3, 4),
	(1184, 23, 31, 174, 1, 2),
	(1185, 23, 32, 174, 1, 18),
	(1186, 23, 32, 174, 2, 12),
	(1187, 23, 32, 174, 3, 4),
	(1191, 23, 31, 175, 1, 2),
	(1192, 23, 32, 175, 1, 18),
	(1193, 23, 32, 175, 2, 12),
	(1194, 23, 32, 175, 3, 4),
	(1198, 23, 31, 176, 1, 2),
	(1199, 23, 32, 176, 1, 18),
	(1200, 23, 32, 176, 2, 12),
	(1201, 23, 32, 176, 3, 4),
	(1205, 23, 31, 177, 1, 2),
	(1206, 23, 32, 177, 1, 18),
	(1207, 23, 32, 177, 2, 12),
	(1208, 23, 32, 177, 3, 4),
	(1212, 23, 31, 178, 1, 2),
	(1213, 23, 32, 178, 1, 18),
	(1214, 23, 32, 178, 2, 12),
	(1215, 23, 32, 178, 3, 4),
	(1219, 23, 31, 179, 1, 2),
	(1220, 23, 32, 179, 1, 18),
	(1221, 23, 32, 179, 2, 12),
	(1222, 23, 32, 179, 3, 4),
	(1226, 23, 31, 180, 1, 2),
	(1227, 23, 32, 180, 1, 18),
	(1228, 23, 32, 180, 2, 12),
	(1229, 23, 32, 180, 3, 4),
	(1233, 23, 31, 181, 1, 2),
	(1234, 23, 32, 181, 1, 18),
	(1235, 23, 32, 181, 2, 12),
	(1236, 23, 32, 181, 3, 4),
	(1240, 23, 31, 182, 1, 2),
	(1241, 23, 32, 182, 1, 18),
	(1242, 23, 32, 182, 2, 12),
	(1243, 23, 32, 182, 3, 4),
	(1247, 23, 31, 183, 1, 2),
	(1248, 23, 32, 183, 1, 18),
	(1249, 23, 32, 183, 2, 12),
	(1250, 23, 32, 183, 3, 4),
	(1254, 23, 31, 184, 1, 2),
	(1255, 23, 32, 184, 1, 18),
	(1256, 23, 32, 184, 2, 12),
	(1257, 23, 32, 184, 3, 4),
	(1261, 23, 31, 185, 1, 2),
	(1262, 23, 32, 185, 1, 18),
	(1263, 23, 32, 185, 2, 12),
	(1264, 23, 32, 185, 3, 4),
	(1268, 23, 31, 186, 1, 2),
	(1269, 23, 32, 186, 1, 18),
	(1270, 23, 32, 186, 2, 12),
	(1271, 23, 32, 186, 3, 4),
	(1275, 23, 31, 187, 1, 2),
	(1276, 23, 32, 187, 1, 18),
	(1277, 23, 32, 187, 2, 12),
	(1278, 23, 32, 187, 3, 4),
	(1282, 23, 31, 188, 1, 2),
	(1283, 23, 32, 188, 1, 18),
	(1284, 23, 32, 188, 2, 12),
	(1285, 23, 32, 188, 3, 4),
	(1289, 23, 31, 189, 1, 2),
	(1290, 23, 32, 189, 1, 18),
	(1291, 23, 32, 189, 2, 12),
	(1292, 23, 32, 189, 3, 4),
	(1296, 23, 31, 190, 1, 2),
	(1297, 23, 32, 190, 1, 18),
	(1298, 23, 32, 190, 2, 12),
	(1299, 23, 32, 190, 3, 4),
	(1303, 23, 31, 191, 1, 2),
	(1304, 23, 32, 191, 1, 18),
	(1305, 23, 32, 191, 2, 12),
	(1306, 23, 32, 191, 3, 4),
	(1310, 23, 31, 192, 1, 2),
	(1311, 23, 32, 192, 1, 18),
	(1312, 23, 32, 192, 2, 12),
	(1313, 23, 32, 192, 3, 4),
	(1317, 23, NULL, 193, 1, 2),
	(1318, 23, 32, 193, 1, 18),
	(1319, 23, 32, 193, 2, 12),
	(1320, 23, 32, 193, 3, 4),
	(1324, 23, NULL, 194, 1, 1),
	(1325, 23, 32, 194, 1, 19),
	(1326, 23, 32, 194, 2, 12),
	(1327, 23, 32, 194, 3, 4),
	(1331, 23, NULL, 195, 1, 1),
	(1332, 23, 32, 195, 1, 19),
	(1333, 23, 32, 195, 2, 12),
	(1334, 23, 32, 195, 3, 4),
	(1338, 23, 32, 196, 1, 20),
	(1339, 23, 32, 196, 2, 12),
	(1340, 23, 32, 196, 3, 4),
	(1341, 23, 32, 197, 1, 20),
	(1342, 23, 32, 197, 2, 12),
	(1343, 23, 32, 197, 3, 4),
	(1344, 23, 32, 198, 1, 20),
	(1345, 23, 32, 198, 2, 12),
	(1346, 23, 32, 198, 3, 4),
	(1347, 23, 32, 199, 1, 20),
	(1348, 23, 32, 199, 2, 12),
	(1349, 23, 32, 199, 3, 4),
	(1350, 23, 32, 200, 1, 20),
	(1351, 23, 32, 200, 2, 12),
	(1352, 23, 32, 200, 3, 4),
	(1353, 23, 32, 201, 1, 20),
	(1354, 23, 32, 201, 2, 12),
	(1355, 23, 32, 201, 3, 4),
	(1356, 23, 32, 202, 1, 20),
	(1357, 23, 32, 202, 2, 12),
	(1358, 23, 32, 202, 3, 4),
	(1359, 23, 32, 203, 1, 20),
	(1360, 23, 32, 203, 2, 12),
	(1361, 23, 32, 203, 3, 4),
	(1362, 23, 32, 204, 1, 20),
	(1363, 23, 32, 204, 2, 12),
	(1364, 23, 32, 204, 3, 4),
	(1365, 23, 32, 205, 1, 20),
	(1366, 23, 32, 205, 2, 12),
	(1367, 23, 32, 205, 3, 4),
	(1368, 23, 32, 206, 1, 20),
	(1369, 23, 32, 206, 2, 12),
	(1370, 23, 32, 206, 3, 4),
	(1371, 23, 32, 207, 1, 20),
	(1372, 23, 32, 207, 2, 12),
	(1373, 23, 32, 207, 3, 4),
	(1374, 23, 32, 208, 1, 20),
	(1375, 23, 32, 208, 2, 12),
	(1376, 23, 32, 208, 3, 4),
	(1377, 23, 32, 209, 1, 20),
	(1378, 23, 32, 209, 2, 12),
	(1379, 23, 32, 209, 3, 4),
	(1380, 23, 32, 210, 1, 20),
	(1381, 23, 32, 210, 2, 12),
	(1382, 23, 32, 210, 3, 4),
	(1383, 23, 32, 211, 1, 20),
	(1384, 23, 32, 211, 2, 12),
	(1385, 23, 32, 211, 3, 4),
	(1386, 23, 32, 212, 1, 20),
	(1387, 23, 32, 212, 2, 12),
	(1388, 23, 32, 212, 3, 4),
	(1389, 24, NULL, 213, 1, 19),
	(1390, 24, NULL, 213, 2, 11),
	(1391, 24, NULL, 213, 3, 4),
	(1392, 24, 33, 213, 1, 1),
	(1393, 24, 33, 213, 2, 1),
	(1396, 24, NULL, 214, 1, 18),
	(1397, 24, NULL, 214, 2, 11),
	(1398, 24, NULL, 214, 3, 4),
	(1399, 24, 33, 214, 1, 1),
	(1400, 24, 33, 214, 2, 1),
	(1401, 24, 34, 214, 1, 1),
	(1403, 24, NULL, 215, 1, 18),
	(1404, 24, NULL, 215, 2, 11),
	(1405, 24, NULL, 215, 3, 4),
	(1406, 24, 33, 215, 1, 1),
	(1407, 24, 33, 215, 2, 1),
	(1408, 24, 34, 215, 1, 1),
	(1410, 24, NULL, 216, 1, 18),
	(1411, 24, NULL, 216, 2, 10),
	(1412, 24, NULL, 216, 3, 4),
	(1413, 24, 33, 216, 1, 1),
	(1414, 24, 33, 216, 2, 1),
	(1415, 24, 34, 216, 1, 1),
	(1416, 24, 34, 216, 2, 1),
	(1417, 24, NULL, 217, 1, 18),
	(1418, 24, NULL, 217, 2, 10),
	(1419, 24, 33, 217, 1, 1),
	(1420, 24, 33, 217, 2, 1),
	(1421, 24, 33, 217, 3, 4),
	(1422, 24, 34, 217, 1, 1),
	(1423, 24, 34, 217, 2, 1),
	(1424, 24, NULL, 218, 1, 17),
	(1425, 24, NULL, 218, 2, 10),
	(1426, 24, 33, 218, 1, 1),
	(1427, 24, 33, 218, 2, 1),
	(1428, 24, 33, 218, 3, 4),
	(1429, 24, 34, 218, 1, 2),
	(1430, 24, 34, 218, 2, 1),
	(1431, 24, NULL, 219, 1, 17),
	(1432, 24, NULL, 219, 2, 4),
	(1433, 24, 33, 219, 1, 1),
	(1434, 24, 33, 219, 2, 7),
	(1435, 24, 33, 219, 3, 4),
	(1436, 24, 34, 219, 1, 2),
	(1437, 24, 34, 219, 2, 1),
	(1438, 24, NULL, 220, 1, 16),
	(1439, 24, NULL, 220, 2, 4),
	(1440, 24, 33, 220, 1, 1),
	(1441, 24, 33, 220, 2, 7),
	(1442, 24, 33, 220, 3, 4),
	(1443, 24, 34, 220, 1, 3),
	(1444, 24, 34, 220, 2, 1),
	(1445, 24, NULL, 221, 1, 16),
	(1446, 24, NULL, 221, 2, 7),
	(1447, 24, 33, 221, 1, 1),
	(1448, 24, 33, 221, 2, 4),
	(1449, 24, 33, 221, 3, 4),
	(1450, 24, 34, 221, 1, 3),
	(1451, 24, 34, 221, 2, 1),
	(1452, 24, NULL, 222, 1, 15),
	(1453, 24, NULL, 222, 2, 7),
	(1454, 24, 33, 222, 1, 1),
	(1455, 24, 33, 222, 2, 4),
	(1456, 24, 33, 222, 3, 4),
	(1457, 24, 34, 222, 1, 4),
	(1458, 24, 34, 222, 2, 1),
	(1459, 24, NULL, 223, 1, 15),
	(1460, 24, NULL, 223, 2, 5),
	(1461, 24, 33, 223, 1, 1),
	(1462, 24, 33, 223, 2, 6),
	(1463, 24, 33, 223, 3, 4),
	(1464, 24, 34, 223, 1, 4),
	(1465, 24, 34, 223, 2, 1),
	(1466, 24, NULL, 224, 1, 15),
	(1467, 24, NULL, 224, 2, 4),
	(1468, 24, 33, 224, 1, 1),
	(1469, 24, 33, 224, 2, 6),
	(1470, 24, 33, 224, 3, 4),
	(1471, 24, 34, 224, 1, 4),
	(1472, 24, 34, 224, 2, 2),
	(1473, 24, NULL, 225, 1, 15),
	(1474, 24, NULL, 225, 2, 4),
	(1475, 24, 33, 225, 1, 1),
	(1476, 24, 33, 225, 2, 6),
	(1477, 24, 33, 225, 3, 4),
	(1478, 24, 34, 225, 1, 4),
	(1479, 24, 34, 225, 2, 2),
	(1480, 24, NULL, 226, 1, 15),
	(1481, 24, NULL, 226, 2, 3),
	(1482, 24, 33, 226, 1, 1),
	(1483, 24, 33, 226, 2, 6),
	(1484, 24, 33, 226, 3, 4),
	(1485, 24, 34, 226, 1, 4),
	(1486, 24, 34, 226, 2, 3),
	(1487, 25, NULL, 227, 1, 28),
	(1488, 25, NULL, 227, 2, 20),
	(1489, 25, NULL, 227, 3, 12),
	(1490, 25, NULL, 227, 4, 3),
	(1491, 25, 35, 227, 4, 1),
	(1494, 25, NULL, 228, 1, 28),
	(1495, 25, NULL, 228, 2, 19),
	(1496, 25, NULL, 228, 3, 12),
	(1497, 25, NULL, 228, 4, 4),
	(1498, 25, 36, 228, 2, 1),
	(1501, 26, NULL, 229, 1, 28),
	(1502, 26, NULL, 229, 2, 20),
	(1503, 26, NULL, 229, 3, 12),
	(1504, 26, NULL, 229, 4, 3),
	(1505, 26, 37, 229, 4, 1),
	(1508, 26, NULL, 230, 1, 28),
	(1509, 26, NULL, 230, 2, 20),
	(1510, 26, NULL, 230, 3, 12),
	(1511, 26, NULL, 230, 4, 3),
	(1512, 26, 38, 230, 4, 1),
	(1515, 27, NULL, 231, 1, 19),
	(1516, 27, NULL, 231, 2, 10),
	(1517, 27, NULL, 231, 3, 4),
	(1518, 27, 39, 231, 1, 1),
	(1519, 27, 39, 231, 2, 2),
	(1522, 27, NULL, 232, 1, 18),
	(1523, 27, NULL, 232, 2, 10),
	(1524, 27, NULL, 232, 3, 4),
	(1525, 27, 39, 232, 1, 1),
	(1526, 27, 39, 232, 2, 2),
	(1527, 27, 40, 232, 1, 1),
	(1529, 27, NULL, 233, 1, 18),
	(1530, 27, NULL, 233, 2, 10),
	(1531, 27, NULL, 233, 3, 3),
	(1532, 27, 39, 233, 1, 1),
	(1533, 27, 39, 233, 2, 2),
	(1534, 27, 39, 233, 3, 1),
	(1535, 27, 40, 233, 1, 1),
	(1536, 27, NULL, 234, 1, 18),
	(1537, 27, NULL, 234, 2, 9),
	(1538, 27, NULL, 234, 3, 3),
	(1539, 27, 39, 234, 1, 1),
	(1540, 27, 39, 234, 2, 2),
	(1541, 27, 39, 234, 3, 1),
	(1542, 27, 40, 234, 1, 1),
	(1543, 27, 40, 234, 2, 1),
	(1551, 28, NULL, 235, 1, 20),
	(1552, 28, NULL, 235, 2, 10),
	(1553, 28, NULL, 235, 3, 4),
	(1554, 28, 41, 235, 2, 2),
	(1558, 28, NULL, 236, 1, 20),
	(1559, 28, NULL, 236, 2, 9),
	(1560, 28, NULL, 236, 3, 4),
	(1561, 28, 41, 236, 2, 2),
	(1562, 28, 42, 236, 2, 1),
	(1565, 28, NULL, 237, 1, 20),
	(1566, 28, NULL, 237, 2, 9),
	(1567, 28, NULL, 237, 3, 4),
	(1568, 28, 41, 237, 2, 2),
	(1569, 28, 42, 237, 2, 1),
	(1572, 28, NULL, 238, 1, 19),
	(1573, 28, NULL, 238, 2, 9),
	(1574, 28, NULL, 238, 3, 4),
	(1575, 28, 41, 238, 2, 2),
	(1576, 28, 42, 238, 1, 1),
	(1577, 28, 42, 238, 2, 1),
	(1579, 28, NULL, 239, 1, 19),
	(1580, 28, NULL, 239, 2, 9),
	(1581, 28, NULL, 239, 3, 4),
	(1582, 28, 41, 239, 2, 2),
	(1583, 28, 42, 239, 1, 1),
	(1584, 28, 42, 239, 2, 1),
	(1586, 28, NULL, 240, 1, 18),
	(1587, 28, NULL, 240, 2, 9),
	(1588, 28, NULL, 240, 3, 4),
	(1589, 28, 41, 240, 2, 2),
	(1590, 28, 42, 240, 1, 2),
	(1591, 28, 42, 240, 2, 1),
	(1593, 28, NULL, 241, 1, 18),
	(1594, 28, NULL, 241, 2, 9),
	(1595, 28, NULL, 241, 3, 4),
	(1596, 28, 41, 241, 2, 2),
	(1597, 28, 42, 241, 1, 2),
	(1598, 28, 42, 241, 2, 1),
	(1600, 28, NULL, 242, 1, 18),
	(1601, 28, NULL, 242, 2, 8),
	(1602, 28, NULL, 242, 3, 4),
	(1603, 28, 41, 242, 2, 2),
	(1604, 28, 42, 242, 1, 2),
	(1605, 28, 42, 242, 2, 2);
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
) ENGINE=InnoDB AUTO_INCREMENT=243 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы conjuncture.game_step: ~180 rows (приблизительно)
DELETE FROM `game_step`;
/*!40000 ALTER TABLE `game_step` DISABLE KEYS */;
INSERT INTO `game_step` (`game_step_id`, `game_id`, `step_game_player_id`, `trand_value`) VALUES
	(47, 21, 27, -3.00),
	(48, 21, 28, -1.00),
	(49, 21, 27, -2.00),
	(50, 21, 28, -1.00),
	(51, 21, 27, 1.00),
	(52, 21, 28, 3.00),
	(53, 21, 27, 0.00),
	(54, 21, 28, -2.00),
	(55, 22, 29, -1.00),
	(56, 22, 30, -1.00),
	(57, 22, 29, 0.00),
	(58, 22, 30, 5.00),
	(59, 22, 29, -1.00),
	(60, 22, 30, 3.00),
	(61, 22, 29, 1.00),
	(62, 22, 30, -1.00),
	(63, 22, 29, 5.00),
	(64, 22, 30, -3.00),
	(65, 22, 29, 1.00),
	(66, 22, 30, 0.00),
	(67, 22, 29, 4.00),
	(68, 22, 30, 1.00),
	(69, 22, 29, 1.00),
	(70, 22, 30, 4.00),
	(71, 22, 29, 0.00),
	(72, 22, 30, -1.00),
	(73, 22, 29, 1.00),
	(74, 22, 30, 0.00),
	(75, 22, 29, -3.00),
	(76, 22, 30, 4.00),
	(77, 22, 29, 3.00),
	(78, 22, 30, 2.00),
	(79, 22, 29, 0.00),
	(80, 22, 30, 5.00),
	(81, 22, 29, 3.00),
	(82, 22, 30, 1.00),
	(83, 22, 29, -1.00),
	(84, 22, 30, 1.00),
	(85, 22, 29, 1.00),
	(86, 22, 30, -1.00),
	(87, 22, 29, 0.00),
	(88, 22, 30, -1.00),
	(89, 22, 29, 2.00),
	(90, 22, 30, -3.00),
	(91, 22, 29, 5.00),
	(92, 22, 30, 1.00),
	(93, 22, 29, 3.00),
	(94, 22, 30, 6.00),
	(95, 22, 29, 2.00),
	(96, 22, 30, 3.00),
	(97, 22, 29, 0.00),
	(98, 22, 30, 1.00),
	(99, 22, 29, 2.00),
	(100, 22, 30, -2.00),
	(101, 22, 29, 1.00),
	(102, 22, 30, 0.00),
	(103, 22, 29, 1.00),
	(104, 22, 30, -1.00),
	(105, 23, 31, 0.00),
	(106, 23, 32, 0.00),
	(107, 23, 31, 5.00),
	(108, 23, 32, 0.00),
	(109, 23, 31, 4.00),
	(110, 23, 32, 0.00),
	(111, 23, 31, 0.00),
	(112, 23, 32, -1.00),
	(113, 23, 31, 2.00),
	(114, 23, 32, -3.00),
	(115, 23, 31, 2.00),
	(116, 23, 32, 1.00),
	(117, 23, 31, 2.00),
	(118, 23, 32, 4.00),
	(119, 23, 31, 1.00),
	(120, 23, 32, 1.00),
	(121, 23, 31, -2.00),
	(122, 23, 32, 1.00),
	(123, 23, 31, 2.00),
	(124, 23, 32, 0.00),
	(125, 23, 31, -1.00),
	(126, 23, 32, 4.00),
	(127, 23, 31, 0.00),
	(128, 23, 32, 1.00),
	(129, 23, 31, 2.00),
	(130, 23, 32, 0.00),
	(131, 23, 31, 0.00),
	(132, 23, 32, 4.00),
	(133, 23, 31, 1.00),
	(134, 23, 32, 2.00),
	(135, 23, 31, 2.00),
	(136, 23, 32, 2.00),
	(137, 23, 31, 2.00),
	(138, 23, 32, -1.00),
	(139, 23, 31, 2.00),
	(140, 23, 32, 1.00),
	(141, 23, 31, -2.00),
	(142, 23, 32, 3.00),
	(143, 23, 31, 0.00),
	(144, 23, 32, 2.00),
	(145, 23, 31, 3.00),
	(146, 23, 32, 0.00),
	(147, 23, 31, 1.00),
	(148, 23, 32, 4.00),
	(149, 23, 31, 5.00),
	(150, 23, 32, -2.00),
	(151, 23, 31, 1.00),
	(152, 23, 32, 3.00),
	(153, 23, 31, 4.00),
	(154, 23, 32, 2.00),
	(155, 23, 31, -2.00),
	(156, 23, 32, 1.00),
	(157, 23, 31, -1.00),
	(158, 23, 32, -2.00),
	(159, 23, 31, -1.00),
	(160, 23, 32, 0.00),
	(161, 23, 31, 0.00),
	(162, 23, 32, 4.00),
	(163, 23, 31, 2.00),
	(164, 23, 32, 4.00),
	(165, 23, 31, 2.00),
	(166, 23, 32, 0.00),
	(167, 23, 31, 0.00),
	(168, 23, 32, 2.00),
	(169, 23, 31, 1.00),
	(170, 23, 32, -3.00),
	(171, 23, 31, 3.00),
	(172, 23, 32, 1.00),
	(173, 23, 31, 3.00),
	(174, 23, 32, 3.00),
	(175, 23, 31, -1.00),
	(176, 23, 32, 6.00),
	(177, 23, 31, 4.00),
	(178, 23, 32, 2.00),
	(179, 23, 31, 2.00),
	(180, 23, 32, 2.00),
	(181, 23, 31, -2.00),
	(182, 23, 32, 2.00),
	(183, 23, 31, 2.00),
	(184, 23, 32, -1.00),
	(185, 23, 31, -1.00),
	(186, 23, 32, -1.00),
	(187, 23, 31, -2.00),
	(188, 23, 32, 4.00),
	(189, 23, 31, 2.00),
	(190, 23, 32, 3.00),
	(191, 23, 31, 0.00),
	(192, 23, 32, -3.00),
	(193, 23, 31, 0.00),
	(194, 23, 32, -3.00),
	(195, 23, 31, 1.00),
	(196, 23, 32, 2.00),
	(197, 23, 31, -3.00),
	(198, 23, 32, -2.00),
	(199, 23, 31, 1.00),
	(200, 23, 32, -1.00),
	(201, 23, 31, 6.00),
	(202, 23, 32, 1.00),
	(203, 23, 31, -3.00),
	(204, 23, 32, 0.00),
	(205, 23, 31, 0.00),
	(206, 23, 32, 2.00),
	(207, 23, 31, 5.00),
	(208, 23, 32, 4.00),
	(209, 23, 31, 3.00),
	(210, 23, 32, 4.00),
	(211, 23, 31, 4.00),
	(212, 23, 32, 0.00),
	(213, 24, 33, 5.00),
	(214, 24, 34, 0.00),
	(215, 24, 33, 0.00),
	(216, 24, 34, 0.00),
	(217, 24, 33, 0.00),
	(218, 24, 34, 1.00),
	(219, 24, 33, 2.00),
	(220, 24, 34, 2.00),
	(221, 24, 33, -4.00),
	(222, 24, 34, 2.00),
	(223, 24, 33, -1.00),
	(224, 24, 34, 2.00),
	(225, 24, 33, 5.00),
	(226, 24, 34, -3.00),
	(227, 25, 35, -1.00),
	(228, 25, 36, 4.00),
	(229, 26, 37, -3.00),
	(230, 26, 38, 0.00),
	(231, 27, 39, 1.00),
	(232, 27, 40, 2.00),
	(233, 27, 39, -1.00),
	(234, 27, 40, -2.00),
	(235, 28, 41, 0.00),
	(236, 28, 42, 0.00),
	(237, 28, 41, 3.00),
	(238, 28, 42, -3.00),
	(239, 28, 41, 0.00),
	(240, 28, 42, 2.00),
	(241, 28, 41, 5.00),
	(242, 28, 42, 2.00);
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
) ENGINE=InnoDB AUTO_INCREMENT=589 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы conjuncture.game_step_results: ~360 rows (приблизительно)
DELETE FROM `game_step_results`;
/*!40000 ALTER TABLE `game_step_results` DISABLE KEYS */;
INSERT INTO `game_step_results` (`game_step_result_id`, `game_player_id`, `game_id`, `game_step_id`, `game_step_result`) VALUES
	(1, 27, 21, 47, 0.00),
	(2, 28, 21, 47, 0.00),
	(4, 27, 21, 48, 0.00),
	(5, 28, 21, 48, -600.00),
	(7, 27, 21, 49, 0.00),
	(8, 28, 21, 49, -1200.00),
	(10, 27, 21, 50, 0.00),
	(11, 28, 21, 50, -800.00),
	(13, 27, 21, 51, 200.00),
	(14, 28, 21, 51, 800.00),
	(16, 27, 21, 52, 600.00),
	(17, 28, 21, 52, 3000.00),
	(19, 27, 21, 53, 0.00),
	(20, 28, 21, 53, 0.00),
	(22, 27, 21, 54, -4000.00),
	(23, 28, 21, 54, -2400.00),
	(25, 29, 22, 55, 0.00),
	(26, 30, 22, 55, 0.00),
	(28, 29, 22, 56, 0.00),
	(29, 30, 22, 56, -1200.00),
	(31, 29, 22, 57, 0.00),
	(32, 30, 22, 57, 0.00),
	(34, 29, 22, 58, 7000.00),
	(35, 30, 22, 58, 9000.00),
	(37, 29, 22, 59, -200.00),
	(38, 30, 22, 59, -1800.00),
	(40, 29, 22, 60, 600.00),
	(41, 30, 22, 60, 6000.00),
	(43, 29, 22, 61, 3800.00),
	(44, 30, 22, 61, 2000.00),
	(46, 29, 22, 62, -3800.00),
	(47, 30, 22, 62, -2200.00),
	(49, 29, 22, 63, 22000.00),
	(50, 30, 22, 63, 11000.00),
	(52, 29, 22, 64, -13200.00),
	(53, 30, 22, 64, -8400.00),
	(55, 29, 22, 65, 4400.00),
	(56, 30, 22, 65, 2800.00),
	(58, 29, 22, 66, 0.00),
	(59, 30, 22, 66, 0.00),
	(61, 29, 22, 67, 17600.00),
	(62, 30, 22, 67, 13600.00),
	(64, 29, 22, 68, 4400.00),
	(65, 30, 22, 68, 3600.00),
	(67, 29, 22, 69, 4400.00),
	(68, 30, 22, 69, 3600.00),
	(70, 29, 22, 70, 17600.00),
	(71, 30, 22, 70, 15200.00),
	(73, 29, 22, 71, 0.00),
	(74, 30, 22, 71, 0.00),
	(76, 29, 22, 72, -4400.00),
	(77, 30, 22, 72, -4400.00),
	(79, 29, 22, 73, 4400.00),
	(80, 30, 22, 73, 4400.00),
	(82, 29, 22, 74, 0.00),
	(83, 30, 22, 74, 0.00),
	(85, 29, 22, 75, -13200.00),
	(86, 30, 22, 75, -15000.00),
	(88, 29, 22, 76, 17600.00),
	(89, 30, 22, 76, 20800.00),
	(91, 29, 22, 77, 13200.00),
	(92, 30, 22, 77, 15600.00),
	(94, 29, 22, 78, 8800.00),
	(95, 30, 22, 78, 10800.00),
	(97, 29, 22, 79, 0.00),
	(98, 30, 22, 79, 0.00),
	(100, 29, 22, 80, 22000.00),
	(101, 30, 22, 80, 30000.00),
	(103, 29, 22, 81, 13200.00),
	(104, 30, 22, 81, 18000.00),
	(106, 29, 22, 82, 4400.00),
	(107, 30, 22, 82, 6200.00),
	(109, 29, 22, 83, -4400.00),
	(110, 30, 22, 83, -6200.00),
	(112, 29, 22, 84, 4400.00),
	(113, 30, 22, 84, 6400.00),
	(115, 29, 22, 85, 4400.00),
	(116, 30, 22, 85, 6400.00),
	(118, 29, 22, 86, -4400.00),
	(119, 30, 22, 86, -6600.00),
	(121, 29, 22, 87, 0.00),
	(122, 30, 22, 87, 0.00),
	(124, 29, 22, 88, -4400.00),
	(125, 30, 22, 88, -7200.00),
	(127, 29, 22, 89, 16400.00),
	(128, 30, 22, 89, 14400.00),
	(130, 29, 22, 90, -24600.00),
	(131, 30, 22, 90, -23400.00),
	(133, 29, 22, 91, 41000.00),
	(134, 30, 22, 91, 39000.00),
	(136, 29, 22, 92, 8200.00),
	(137, 30, 22, 92, 7800.00),
	(139, 29, 22, 93, 24600.00),
	(140, 30, 22, 93, 23400.00),
	(142, 29, 22, 94, 49200.00),
	(143, 30, 22, 94, 46800.00),
	(145, 29, 22, 95, 16400.00),
	(146, 30, 22, 95, 15600.00),
	(148, 29, 22, 96, 24600.00),
	(149, 30, 22, 96, 23400.00),
	(151, 29, 22, 97, 0.00),
	(152, 30, 22, 97, 0.00),
	(154, 29, 22, 98, 8200.00),
	(155, 30, 22, 98, 7800.00),
	(157, 29, 22, 99, 9200.00),
	(158, 30, 22, 99, 15600.00),
	(160, 29, 22, 100, -9200.00),
	(161, 30, 22, 100, -18000.00),
	(163, 29, 22, 101, 3800.00),
	(164, 30, 22, 101, 9000.00),
	(166, 29, 22, 102, 0.00),
	(167, 30, 22, 102, 0.00),
	(169, 29, 22, 103, 3800.00),
	(170, 30, 22, 103, 10200.00),
	(172, 29, 22, 104, -3800.00),
	(173, 30, 22, 104, -10400.00),
	(175, 31, 23, 105, 0.00),
	(176, 32, 23, 105, 0.00),
	(178, 31, 23, 106, 0.00),
	(179, 32, 23, 106, 0.00),
	(181, 31, 23, 107, 2000.00),
	(182, 32, 23, 107, 3000.00),
	(184, 31, 23, 108, 0.00),
	(185, 32, 23, 108, 0.00),
	(187, 31, 23, 109, 1600.00),
	(188, 32, 23, 109, 4800.00),
	(190, 31, 23, 110, 0.00),
	(191, 32, 23, 110, 0.00),
	(193, 31, 23, 111, 0.00),
	(194, 32, 23, 111, 0.00),
	(196, 31, 23, 112, -400.00),
	(197, 32, 23, 112, -2400.00),
	(199, 31, 23, 113, 800.00),
	(200, 32, 23, 113, 4800.00),
	(202, 31, 23, 114, -1200.00),
	(203, 32, 23, 114, -10800.00),
	(205, 31, 23, 115, 800.00),
	(206, 32, 23, 115, 7200.00),
	(208, 31, 23, 116, 400.00),
	(209, 32, 23, 116, 3800.00),
	(211, 31, 23, 117, 800.00),
	(212, 32, 23, 117, 7600.00),
	(214, 31, 23, 118, 1600.00),
	(215, 32, 23, 118, 17600.00),
	(217, 31, 23, 119, 400.00),
	(218, 32, 23, 119, 4400.00),
	(220, 31, 23, 120, 400.00),
	(221, 32, 23, 120, 4600.00),
	(223, 31, 23, 121, -800.00),
	(224, 32, 23, 121, -9200.00),
	(226, 31, 23, 122, 400.00),
	(227, 32, 23, 122, 5200.00),
	(229, 31, 23, 123, 800.00),
	(230, 32, 23, 123, 10400.00),
	(232, 31, 23, 124, 0.00),
	(233, 32, 23, 124, 0.00),
	(235, 31, 23, 125, -400.00),
	(236, 32, 23, 125, -5800.00),
	(238, 31, 23, 126, 1600.00),
	(239, 32, 23, 126, 25600.00),
	(241, 31, 23, 127, 0.00),
	(242, 32, 23, 127, 0.00),
	(244, 31, 23, 128, 400.00),
	(245, 32, 23, 128, 6600.00),
	(247, 31, 23, 129, 800.00),
	(248, 32, 23, 129, 13200.00),
	(250, 31, 23, 130, 0.00),
	(251, 32, 23, 130, 0.00),
	(253, 31, 23, 131, 0.00),
	(254, 32, 23, 131, 0.00),
	(256, 31, 23, 132, 1600.00),
	(257, 32, 23, 132, 33600.00),
	(259, 31, 23, 133, 400.00),
	(260, 32, 23, 133, 8400.00),
	(262, 31, 23, 134, 800.00),
	(263, 32, 23, 134, 17200.00),
	(265, 31, 23, 135, 800.00),
	(266, 32, 23, 135, 17200.00),
	(268, 31, 23, 136, 800.00),
	(269, 32, 23, 136, 18400.00),
	(271, 31, 23, 137, 800.00),
	(272, 32, 23, 137, 18400.00),
	(274, 31, 23, 138, -400.00),
	(275, 32, 23, 138, -9400.00),
	(277, 31, 23, 139, 800.00),
	(278, 32, 23, 139, 18800.00),
	(280, 31, 23, 140, 400.00),
	(281, 32, 23, 140, 9600.00),
	(283, 31, 23, 141, -800.00),
	(284, 32, 23, 141, -19200.00),
	(286, 31, 23, 142, 1200.00),
	(287, 32, 23, 142, 29400.00),
	(289, 31, 23, 143, 0.00),
	(290, 32, 23, 143, 0.00),
	(292, 31, 23, 144, 800.00),
	(293, 32, 23, 144, 20800.00),
	(295, 31, 23, 145, 1200.00),
	(296, 32, 23, 145, 31200.00),
	(298, 31, 23, 146, 0.00),
	(299, 32, 23, 146, 0.00),
	(301, 31, 23, 147, 400.00),
	(302, 32, 23, 147, 11600.00),
	(304, 31, 23, 148, 1600.00),
	(305, 32, 23, 148, 47200.00),
	(307, 31, 23, 149, 2000.00),
	(308, 32, 23, 149, 59000.00),
	(310, 31, 23, 150, -800.00),
	(311, 32, 23, 150, -24000.00),
	(313, 31, 23, 151, 400.00),
	(314, 32, 23, 151, 12000.00),
	(316, 31, 23, 152, 1200.00),
	(317, 32, 23, 152, 37800.00),
	(319, 31, 23, 153, 1600.00),
	(320, 32, 23, 153, 50400.00),
	(322, 31, 23, 154, 800.00),
	(323, 32, 23, 154, 25600.00),
	(325, 31, 23, 155, -800.00),
	(326, 32, 23, 155, -25600.00),
	(328, 31, 23, 156, 400.00),
	(329, 32, 23, 156, 13000.00),
	(331, 31, 23, 157, -400.00),
	(332, 32, 23, 157, -13000.00),
	(334, 31, 23, 158, -800.00),
	(335, 32, 23, 158, -26400.00),
	(337, 31, 23, 159, -400.00),
	(338, 32, 23, 159, -13200.00),
	(340, 31, 23, 160, 0.00),
	(341, 32, 23, 160, 0.00),
	(343, 31, 23, 161, 0.00),
	(344, 32, 23, 161, 0.00),
	(346, 31, 23, 162, 1600.00),
	(347, 32, 23, 162, 54400.00),
	(349, 31, 23, 163, 800.00),
	(350, 32, 23, 163, 27200.00),
	(352, 31, 23, 164, 1600.00),
	(353, 32, 23, 164, 55200.00),
	(355, 31, 23, 165, 800.00),
	(356, 32, 23, 165, 27600.00),
	(358, 31, 23, 166, 0.00),
	(359, 32, 23, 166, 0.00),
	(361, 31, 23, 167, 0.00),
	(362, 32, 23, 167, 0.00),
	(364, 31, 23, 168, 800.00),
	(365, 32, 23, 168, 30400.00),
	(367, 31, 23, 169, 400.00),
	(368, 32, 23, 169, 15200.00),
	(370, 31, 23, 170, -1200.00),
	(371, 32, 23, 170, -46200.00),
	(373, 31, 23, 171, 1200.00),
	(374, 32, 23, 171, 46200.00),
	(376, 31, 23, 172, 400.00),
	(377, 32, 23, 172, 15600.00),
	(379, 31, 23, 173, 1200.00),
	(380, 32, 23, 173, 46800.00),
	(382, 31, 23, 174, 1200.00),
	(383, 32, 23, 174, 46800.00),
	(385, 31, 23, 175, -400.00),
	(386, 32, 23, 175, -15600.00),
	(388, 31, 23, 176, 2400.00),
	(389, 32, 23, 176, 93600.00),
	(391, 31, 23, 177, 1600.00),
	(392, 32, 23, 177, 62400.00),
	(394, 31, 23, 178, 800.00),
	(395, 32, 23, 178, 31200.00),
	(397, 31, 23, 179, 800.00),
	(398, 32, 23, 179, 31200.00),
	(400, 31, 23, 180, 800.00),
	(401, 32, 23, 180, 31200.00),
	(403, 31, 23, 181, -800.00),
	(404, 32, 23, 181, -31200.00),
	(406, 31, 23, 182, 800.00),
	(407, 32, 23, 182, 31200.00),
	(409, 31, 23, 183, 800.00),
	(410, 32, 23, 183, 31200.00),
	(412, 31, 23, 184, -400.00),
	(413, 32, 23, 184, -15600.00),
	(415, 31, 23, 185, -400.00),
	(416, 32, 23, 185, -15600.00),
	(418, 31, 23, 186, -400.00),
	(419, 32, 23, 186, -15600.00),
	(421, 31, 23, 187, -800.00),
	(422, 32, 23, 187, -31200.00),
	(424, 31, 23, 188, 1600.00),
	(425, 32, 23, 188, 62400.00),
	(427, 31, 23, 189, 800.00),
	(428, 32, 23, 189, 31200.00),
	(430, 31, 23, 190, 1200.00),
	(431, 32, 23, 190, 46800.00),
	(433, 31, 23, 191, 0.00),
	(434, 32, 23, 191, 0.00),
	(436, 31, 23, 192, -1200.00),
	(437, 32, 23, 192, -46800.00),
	(439, 31, 23, 193, 0.00),
	(440, 32, 23, 193, 0.00),
	(442, 31, 23, 194, 0.00),
	(443, 32, 23, 194, -47400.00),
	(445, 31, 23, 195, 0.00),
	(446, 32, 23, 195, 15800.00),
	(448, 31, 23, 196, 0.00),
	(449, 32, 23, 196, 32000.00),
	(451, 31, 23, 197, 0.00),
	(452, 32, 23, 197, -48000.00),
	(454, 31, 23, 198, 0.00),
	(455, 32, 23, 198, -32000.00),
	(457, 31, 23, 199, 0.00),
	(458, 32, 23, 199, 16000.00),
	(460, 31, 23, 200, 0.00),
	(461, 32, 23, 200, -16000.00),
	(463, 31, 23, 201, 0.00),
	(464, 32, 23, 201, 96000.00),
	(466, 31, 23, 202, 0.00),
	(467, 32, 23, 202, 16000.00),
	(469, 31, 23, 203, 0.00),
	(470, 32, 23, 203, -48000.00),
	(472, 31, 23, 204, 0.00),
	(473, 32, 23, 204, 0.00),
	(475, 31, 23, 205, 0.00),
	(476, 32, 23, 205, 0.00),
	(478, 31, 23, 206, 0.00),
	(479, 32, 23, 206, 32000.00),
	(481, 31, 23, 207, 0.00),
	(482, 32, 23, 207, 80000.00),
	(484, 31, 23, 208, 0.00),
	(485, 32, 23, 208, 64000.00),
	(487, 31, 23, 209, 0.00),
	(488, 32, 23, 209, 48000.00),
	(490, 31, 23, 210, 0.00),
	(491, 32, 23, 210, 64000.00),
	(493, 31, 23, 211, 0.00),
	(494, 32, 23, 211, 64000.00),
	(496, 31, 23, 212, 0.00),
	(497, 32, 23, 212, 0.00),
	(499, 33, 24, 213, 4000.00),
	(500, 34, 24, 213, 0.00),
	(502, 33, 24, 214, 0.00),
	(503, 34, 24, 214, 0.00),
	(505, 33, 24, 215, 0.00),
	(506, 34, 24, 215, 0.00),
	(508, 33, 24, 216, 0.00),
	(509, 34, 24, 216, 0.00),
	(511, 33, 24, 217, 0.00),
	(512, 34, 24, 217, 0.00),
	(514, 33, 24, 218, 5600.00),
	(515, 34, 24, 218, 1000.00),
	(517, 33, 24, 219, 18400.00),
	(518, 34, 24, 219, 2000.00),
	(520, 33, 24, 220, 18400.00),
	(521, 34, 24, 220, 2400.00),
	(523, 33, 24, 221, -29600.00),
	(524, 34, 24, 221, -4800.00),
	(526, 33, 24, 222, 14800.00),
	(527, 34, 24, 222, 2800.00),
	(529, 33, 24, 223, -8600.00),
	(530, 34, 24, 223, -1400.00),
	(532, 33, 24, 224, 17200.00),
	(533, 34, 24, 224, 4000.00),
	(535, 33, 24, 225, 43000.00),
	(536, 34, 24, 225, 10000.00),
	(538, 33, 24, 226, -25800.00),
	(539, 34, 24, 226, -7800.00),
	(541, 35, 25, 227, -2000.00),
	(542, 36, 25, 227, 0.00),
	(544, 35, 25, 228, 0.00),
	(545, 36, 25, 228, 2400.00),
	(547, 37, 26, 229, -6000.00),
	(548, 38, 26, 229, 0.00),
	(550, 37, 26, 230, 0.00),
	(551, 38, 26, 230, 0.00),
	(553, 39, 27, 231, 1400.00),
	(554, 40, 27, 231, 0.00),
	(556, 39, 27, 232, 2800.00),
	(557, 40, 27, 232, 400.00),
	(559, 39, 27, 233, -2600.00),
	(560, 40, 27, 233, -200.00),
	(562, 39, 27, 234, -5200.00),
	(563, 40, 27, 234, -1600.00),
	(565, 41, 28, 235, 0.00),
	(566, 42, 28, 235, 0.00),
	(568, 41, 28, 236, 0.00),
	(569, 42, 28, 236, 0.00),
	(571, 41, 28, 237, 3600.00),
	(572, 42, 28, 237, 1800.00),
	(574, 41, 28, 238, -3600.00),
	(575, 42, 28, 238, -2400.00),
	(577, 41, 28, 239, 0.00),
	(578, 42, 28, 239, 0.00),
	(580, 41, 28, 240, 2400.00),
	(581, 42, 28, 240, 2000.00),
	(583, 41, 28, 241, 6000.00),
	(584, 42, 28, 241, 5000.00),
	(586, 41, 28, 242, 2400.00),
	(587, 42, 28, 242, 3200.00);
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
	(3, 'k', '+79162664924', '7', 'kalistrat', 'kalistratov', 'koldybovich', '1985-06-26', 'k_12.png', 'kauredinas@mail.ru', 439661.00, '2017-03-01 00:00:00', 77.70, 12, '2017-05-09 20:46:13'),
	(4, 'ADMIN', '0', '7onofN', 'ADMIN', 'ADMIN', 'ADMIN', '2016-08-09', NULL, 'admin@mail.ru', 544300.00, '2017-04-01 00:00:00', 2.00, 0, '2017-05-09 20:45:49');
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
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_close_game_player`(IN `eGameId` int, IN `eUserLog` varchar(50), IN `eSign` CHAR(1))
begin
declare i_total_value decimal(10,2);
declare i_game_player_id int;
declare iGameMode int;
declare i_total_admin_value decimal(10,2);
declare i_game_admin_player_id int;

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
,gp.game_status=eSign
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

select g.is_single_game into iGameMode
from game g
where g.game_id=eGameId;

if (iGameMode = 1) and (eSign = 'R') then
	
	select t.passiv_value+t.sale_rates_value into i_total_admin_value
	from (
	select gp.game_player_id
	,ifnull(gp.current_passiv_value,0) passiv_value
	,ifnull(sum(ft.field_price),0) sale_rates_value
	from game_player gp
	join player p on p.player_id=gp.player_id
	left join game_field gf on gf.game_player_id=gp.game_player_id
	left join field_type ft on ft.field_type_id = gf.field_type_id
	where gp.game_id=eGameId
	and p.player_log='ADMIN'
	group by gp.game_player_id
	,gp.current_passiv_value
	) t;
	
	set i_game_admin_player_id = f_get_game_player_id(eGameId,'ADMIN');
	
	update game_player gp
	set gp.is_active=0
	,gp.current_passiv_value=0
	,gp.out_time=sysdate()
	,gp.out_passiv_value=i_total_admin_value
	,gp.game_status=eSign
	where gp.game_player_id = i_game_admin_player_id;
	
	update game_field gf
	set gf.game_player_id=null
	where gf.game_id = eGameId
	and gf.game_player_id=i_game_admin_player_id;
	
	update player p
	set p.balance=p.balance + i_total_admin_value
	where p.player_log = 'ADMIN';
	
	update game g
	set g.date_till = sysdate()
	where g.game_id = eGameId;

end if;

end//
DELIMITER ;


-- Дамп структуры для процедура conjuncture.p_close_lossers
DELIMITER //
CREATE DEFINER=`gumbler`@`localhost` PROCEDURE `p_close_lossers`(IN `eGameId` int)
begin
##Here is criteria of close player

declare i int default 0;
declare row_cnt int;
declare iGameId INT;
declare iUserLog varchar(50);


declare cur1 cursor for 
select gp.game_id
,p.player_log
from game_player gp
join player p on p.player_id=gp.player_id
where gp.game_id=eGameId
and gp.is_active=1
and gp.current_passiv_value<=0;

select count(*) into row_cnt
from game_player gp
join player p on p.player_id=gp.player_id
where gp.game_id=eGameId
and gp.is_active=1
and gp.current_passiv_value<=0;


open cur1;

	while i<row_cnt do
	
		fetch cur1 into iGameId, iUserLog;
		call p_close_game_player(iGameId,iUserLog,'L');
		set i = i + 1;
	
	end while;

close cur1;

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
declare is_player_won int;
declare is_admin_won int;

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
call p_close_lossers(eGameId);

set is_player_won = f_is_player_won(eGameId,ePlayerLog);

if (is_player_won != 1) then

	update game_player gp
	set gp.last_step_id = i_game_step_id
	where gp.game_player_id = i_game_player_id;
	
	call p_switch_game_player(eGameId);

else 

	call p_close_game_player(eGameId,ePlayerLog,'W');
	
	update game g
	set g.date_till=sysdate()
	where g.game_id = eGameId;
		

end if;

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
	call p_close_lossers(eGameId);
	
	set is_admin_won = f_is_player_won(eGameId,'ADMIN');
	
	if (is_admin_won != 1) then
	
		update game_player gp
		set gp.last_step_id = i_game_step_id
		where gp.game_player_id = i_admin_game_player_id;
		
		call p_switch_game_player(eGameId);

	
	else 
	
		call p_close_game_player(eGameId,'ADMIN','W');
		
		update game g
		set g.date_till=sysdate()
		where g.game_id = eGameId;
		
	
	end if;


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

select min(gpp.game_player_id) into i_next_game_player_id
from game_player gpp
where gpp.game_id=eGameId
and gpp.is_active=1
and ifnull(gpp.last_step_id,0) in (
select min(ifnull(gp.last_step_id,0))
from game_player gp
where gp.game_id=eGameId
and gp.is_active=1
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
