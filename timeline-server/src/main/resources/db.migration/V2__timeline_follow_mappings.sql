CREATE TABLE `timeline`.`timeline_follow_mappings` (

  `follower_login_id` VARCHAR(100) NOT NULL COMMENT '팔로워의 login id',
  `following_login_id` VARCHAR(100) NOT NULL COMMENT '팔로잉하는 대상의 login id',

  PRIMARY KEY (`follower_login_id`, `following_login_id`)

) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '팔로우 관계';

