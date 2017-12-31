-- auto Generated on 2017-09-11 19:39:40 
-- DROP TABLE IF EXISTS `app`;
CREATE TABLE IF NOT EXISTS app (
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `parent_id` INTEGER(12) DEFAULT -1 COMMENT 'parentId',
    `icon` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'icon',
    `name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'name',
    `host` VARCHAR(50)  DEFAULT '' COMMENT 'host',
    `port` VARCHAR(50)  DEFAULT '' COMMENT 'port',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'app' ;

-- auto Generated on 2017-09-11 19:39:40
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS user(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'name',
    `pwd` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'pwd',
    `status` INTEGER(12) DEFAULT -1 COMMENT 'status',
    `level` INTEGER(12)  DEFAULT -1 COMMENT 'level',
    `gmt_create` DATETIME DEFAULT '1000-01-01 00:00:00' COMMENT 'gmtCreate',
    `gmt_update` DATETIME DEFAULT '1000-01-01 00:00:00' COMMENT 'gmtUpdate',
    `last_login` DATETIME DEFAULT '1000-01-01 00:00:00' COMMENT 'lastLogin',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'user';

-- auto Generated on 2017-09-11 19:39:40
-- DROP TABLE IF EXISTS `connect_history`;
CREATE TABLE IF NOT EXISTS connect_history(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `userId` INTEGER(20) NOT NULL DEFAULT -1 COMMENT 'userId',
    `appId` INTEGER(20) NOT NULL DEFAULT -1 COMMENT 'appId',
    `appName`  VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'appName',
    `connect_start` DATETIME DEFAULT '1000-01-01 00:00:00' COMMENT 'connect_start',
    `connect_end` DATETIME DEFAULT '1000-01-01 00:00:00' COMMENT 'connect_end',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'connect_history';

-- auto Generated on 2017-09-11 19:39:40
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS company(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'name',
    `detail` VARCHAR(2048) NOT NULL DEFAULT '' COMMENT 'detail',
    `logo` VARCHAR(50) DEFAULT -1 COMMENT 'logo',
    `gmt_create` DATETIME DEFAULT '1000-01-01 00:00:00' COMMENT 'gmtCreate',
    `gmt_update` DATETIME DEFAULT '1000-01-01 00:00:00' COMMENT 'gmtUpdate',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'company';
/*BEGIN
DECLARE num INT;
SELECT COUNT(*) into num from company;
IF num < 1
THEN
  INSERT INTO company(name,detail) values("test","testdetail");
end IF;
END;*/

