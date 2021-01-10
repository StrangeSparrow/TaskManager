CREATE TABLE `task_manager_db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `password` VARCHAR(20) NULL,
  `role` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `task_manager_db`.`task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL,
  `owner_id` INT NULL,
  `executor_id` INT NULL,
  `status` VARCHAR(20) NOT NULL,
  `project_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `task_manager_db`.`project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `task_manager_db`.`user_to_project` (
  `user_id` INT NOT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `project_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `task_manager_db`.`task_time` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `task_id` INT NOT NULL,
  `time_task` TIME NULL,
  `date_task` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;