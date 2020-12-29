INSERT INTO `task_manager_db`.`role` (`id`, `name`) VALUES ('1', 'Admin');
INSERT INTO `task_manager_db`.`role` (`id`, `name`) VALUES ('2', 'Manager');
INSERT INTO `task_manager_db`.`role` (`id`, `name`) VALUES ('3', 'Executor');

INSERT INTO `task_manager_db`.`status` (`id`, `name`) VALUES ('1', 'Started');
INSERT INTO `task_manager_db`.`status` (`id`, `name`) VALUES ('2', 'Execut');
INSERT INTO `task_manager_db`.`status` (`id`, `name`) VALUES ('3', 'Finished');

INSERT INTO `task_manager_db`.`user` (`id`, `name`, `password`, `role_id`) VALUES ('1', 'Admin', 'admin', '1');