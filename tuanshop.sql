drop table if exists user;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `address` varchar(100) NOT NULL DEFAULT '',
  `userpwd` varchar(100) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `user`
--

INSERT INTO `user` (`id`, `username`, `address`, `userpwd`, `gmt_create`, `gmt_modified`) VALUES
(1, 'admin', '北京第20胡同', 'e10adc3949ba59abbe56e057f20f883e', '2014-06-17 21:15:49', '2014-06-17 21:15:49'),
(2, 'guest', 'beijing', 'e10adc3949ba59abbe56e057f20f883e', '2014-06-17 21:16:24', '2014-06-17 21:16:24');

drop table if exists role;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `role`
--

INSERT INTO `role` (`id`, `name`, `gmt_create`, `gmt_modified`, `description`) VALUES
(1, '管理员', '2014-06-17 21:16:41', '2014-06-17 21:16:41', '管理员'),
(2, '游客', '2014-06-17 21:16:47', '2014-06-17 21:16:47', '游客');


--
-- 用户角色关联 `user_role`
--
drop table if exists user_role;
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

--
-- 导出表中的数据 `user_role`
--

INSERT INTO `user_role` (`id`, `user_id`, `role_id`, `gmt_create`, `gmt_modified`, `description`) VALUES
(1, 2, 2, '2014-06-17 21:17:25', '2014-06-17 21:17:25', NULL),
(2, 1, 1, '2014-06-17 21:17:59', '2014-06-17 21:17:59', NULL);

--
-- 表的结构 `authority`
--
drop table if exists authority;
CREATE TABLE IF NOT EXISTS `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `authority`
--

INSERT INTO `authority` (`id`, `name`, `gmt_create`, `gmt_modified`, `description`) VALUES
(1, 'sa', '2014-06-16 16:50:15', '2014-06-16 16:50:15', '最高权限'),
(2, '用户添加', '2014-06-16 17:26:18', '2014-06-16 17:35:37', '用户添加'),
(3, '用户修改', '2014-06-16 17:26:53', '2014-06-16 17:35:47', '用户修改'),
(4, '用户删除', '2014-06-16 17:27:10', '2014-06-16 17:36:00', '用户删除'),
(5, '用户查询', '2014-06-16 17:27:10', '2014-06-16 17:36:00', '用户查询'),
(6, '角色添加', '2014-06-16 17:36:23', '2014-06-16 17:36:23', '角色添加'),
(7, '角色修改', '2014-06-16 17:36:39', '2014-06-16 17:36:52', '角色修改'),
(8, '角色添加', '2014-06-16 17:37:18', '2014-06-16 17:37:18', '角色添加'),
(9, '添加权限', '2014-06-16 17:37:40', '2014-06-16 17:37:40', '权限添加'),
(10, '权限删除', '2014-06-16 17:37:56', '2014-06-16 17:37:56', '删除权限'),
(11, '修改权限', '2014-06-16 17:38:19', '2014-06-16 17:38:19', '权限修改'),
(12, '角色查询', '2014-06-16 17:39:14', '2014-06-16 17:39:14', '查询角色'),
(13, '权限查询', '2014-06-16 17:39:43', '2014-06-16 17:39:43', '权限查询'),
(14, '角色分配', '2014-06-16 17:39:43', '2014-06-16 17:39:43', '角色分配'),
(15, '权限分配', '2014-06-16 17:39:43', '2014-06-16 17:39:43', '权限分配');
--
-- 角色权限关联 `role_authority`
--
drop table if exists role_authority;
CREATE TABLE IF NOT EXISTS `role_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `authorith_id` bigint(20) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 导出表中的数据 `role_authority`
--


INSERT INTO `role_authority` (`id`, `role_id`, `authorith_id`, `gmt_create`, `gmt_modified`, `description`) VALUES
(1, 2, 13, '2014-06-17 21:17:13', '2014-06-17 21:17:13', NULL),
(2, 2, 12, '2014-06-17 21:17:13', '2014-06-17 21:17:13', NULL),
(3, 2, 5, '2014-06-17 21:17:13', '2014-06-17 21:17:13', NULL),
(4, 1, 15, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(5, 1, 14, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(6, 1, 13, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(7, 1, 12, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(8, 1, 11, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(9, 1, 10, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(10, 1, 9, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(11, 1, 8, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(12, 1, 7, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(13, 1, 6, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(14, 1, 5, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(15, 1, 4, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(16, 1, 3, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL),
(17, 1, 2, '2014-06-17 22:13:09', '2014-06-17 22:13:09', NULL);


drop table if exists city;
CREATE TABLE IF NOT EXISTS `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

drop table if exists sort;
CREATE TABLE IF NOT EXISTS `sort` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `max_name` varchar(20) NOT NULL,
   `main_name` varchar(20) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


drop table if exists groups;
CREATE TABLE IF NOT EXISTS `groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tuan_id` varchar(20) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;



drop table if exists groupon;
CREATE TABLE IF NOT EXISTS `groupon` (
    'id' bigint(20)  NOT NULL AUTO_INCREMENT,
    'city_name' varchar(20) NOT NULL,
    'source'     varchar(20) NOT NULL,
	'title'        varchar(20) NOT NULL,
	'describes' varchar(20) NOT NULL,
	'img_url '   varchar(20) NOT NULL,
   'max_type'  varchar(20) NOT NULL,
   'main_tipe'  varchar(20) NOT NULL,
   'start_time' datetime NOT NULL,
   'over_time' datetime NOT NULL,
    'purchase_count' varchar(20) NOT NULL,
    'price'      varchar(20) NOT NULL,
    'current_price' varchar(20) NOT NULL,
    'criteria'   varchar(20) NOT NULL,
    'notice'    varchar(20) NOT NULL,
    'detail'     varchar(20) NOT NULL,
    'bs_name' varchar(20) NOT NULL,
    'phon'      varchar(20) DEFAULT NULL,
    'bs_address' varchar(20) NOT NULL,
    'longitude' varchar(20) NOT NULL,
    'latitude'    varchar(20) NOT NULL,
    'trafficInfo' varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;
