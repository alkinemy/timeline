CREATE TABLE `timeline`.`timeline_messages` (

  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'pk',
  `message_id` VARCHAR(100) NOT NULL COMMENT 'message id',
  `author_login_id` VARCHAR(100) NOT NULL COMMENT '작성자 login id',
  `author_name` VARCHAR(100) NOT NULL COMMENT '작성자 이름',
  `contents` VARCHAR(1000) NOT NULL COMMENT '메시지 내용',
  `parent_message_id` VARCHAR(100) NULL COMMENT '상위 message id',
  `created_date` DATETIME NOT NULL COMMENT '등록 일시',
  `modified_date` DATETIME NOT NULL COMMENT '변경 일시',

  PRIMARY KEY (`id`),
  UNIQUE INDEX `timeline_messages_uk01` (`message_id`)

) ENGINE = InnoDB CHARACTER SET = utf8 COMMENT = '타임라인 메시지';
