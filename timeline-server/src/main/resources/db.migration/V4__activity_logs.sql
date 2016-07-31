CREATE TABLE `timeline`.`activity_logs` (

  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `from_login_id` VARCHAR(100) NOT NULL COMMENT 'from user login id',
  `from_name` VARCHAR(100) NULL COMMENT 'from user name',
  `to_login_id` VARCHAR(100) NOT NULL COMMENT 'to user login id',
  `to_name` VARCHAR(100) NULL COMMENT 'to user name',
  `type` VARCHAR(50) NOT NULL COMMENT 'activity type',
  `linkUrl` VARCHAR(200) NULL COMMENT 'link',

  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = 'activity logs';
