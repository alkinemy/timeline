CREATE TABLE `timeline`.`activity_logs` (

  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `from_login_id` VARCHAR(100) NOT NULL COMMENT 'from user login id',
  `from_name` VARCHAR(100) NULL COMMENT 'from user name',
  `to_login_id` VARCHAR(100) NOT NULL COMMENT 'to user login id',
  `to_name` VARCHAR(100) NULL COMMENT 'to user name',
  `type` VARCHAR(50) NOT NULL COMMENT 'activity type',
  `linkUrl` VARCHAR(200) NULL COMMENT 'link',
  `created_date` DATETIME NOT NULL COMMENT '등록 일시',
  `last_modified_date` DATETIME NOT NULL COMMENT '변경 일시',

  PRIMARY KEY (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = 'activity logs';
