ALTER TABLE `task_manager_db`.`user`
ADD INDEX `user_role_idx` (`role_id` ASC) VISIBLE;
;
ALTER TABLE `task_manager_db`.`user`
ADD CONSTRAINT `user_role`
  FOREIGN KEY (`role_id`)
  REFERENCES `task_manager_db`.`role` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `task_manager_db`.`user_to_project`
ADD INDEX `project_key_idx` (`project_id` ASC) VISIBLE;
;
ALTER TABLE `task_manager_db`.`user_to_project`
ADD CONSTRAINT `user_project_key`
  FOREIGN KEY (`user_id`)
  REFERENCES `task_manager_db`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `project_user_key`
  FOREIGN KEY (`project_id`)
  REFERENCES `task_manager_db`.`project` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `task_manager_db`.`task`
ADD INDEX `owner_key_idx` (`owner_id` ASC) VISIBLE,
ADD INDEX `executor_key_idx` (`executor_id` ASC) VISIBLE,
ADD INDEX `project_key_idx` (`project_id` ASC) VISIBLE,
ADD INDEX `status_key_idx` (`task_status_id` ASC) VISIBLE;
;
ALTER TABLE `task_manager_db`.`task`
ADD CONSTRAINT `owner_key`
  FOREIGN KEY (`owner_id`)
  REFERENCES `task_manager_db`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `executor_key`
  FOREIGN KEY (`executor_id`)
  REFERENCES `task_manager_db`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `project_key`
  FOREIGN KEY (`project_id`)
  REFERENCES `task_manager_db`.`project` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `status_key`
  FOREIGN KEY (`task_status_id`)
  REFERENCES `task_manager_db`.`status` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `task_manager_db`.`task_time`
ADD INDEX `user_key_idx` (`user_id` ASC) VISIBLE,
ADD INDEX `task_key_idx` (`task_id` ASC) VISIBLE;
;
ALTER TABLE `task_manager_db`.`task_time`
ADD CONSTRAINT `user_key`
  FOREIGN KEY (`user_id`)
  REFERENCES `task_manager_db`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `task_key`
  FOREIGN KEY (`task_id`)
  REFERENCES `task_manager_db`.`task` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
