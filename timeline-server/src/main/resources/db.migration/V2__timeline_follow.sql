CREATE TABLE `timeline`.`timeline_follows` (

  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `follower_login_id` VARCHAR(100) NOT NULL COMMENT '팔로워 login id',
  `follower_name` VARCHAR(100) NOT NULL COMMENT '팔로워 이름',
  `following_login_id` VARCHAR(100) NOT NULL COMMENT '팔로잉 대상 login id',
  `following_name` VARCHAR(100) NOT NULL COMMENT '팔로잉 대상 이름',
  `follow_date` DATETIME NOT NULL COMMENT '팔로우 일시',
  `created_date` DATETIME NOT NULL COMMENT '등록 일시',
  `last_modified_date` DATETIME NOT NULL COMMENT '변경 일시',

  PRIMARY KEY (`id`),
  UNIQUE INDEX `timeline_follow_mappings_uk01` (`follower_login_id`, `following_login_id`)

) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '팔로우 관계';

