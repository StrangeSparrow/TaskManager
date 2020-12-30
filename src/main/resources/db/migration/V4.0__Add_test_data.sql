INSERT INTO `task_manager_db`.`user` (`id`, `name`, `password`, `role_id`) VALUES ('2', 'tolik', 'tolik', '2');
INSERT INTO `task_manager_db`.`user` (`id`, `name`, `password`, `role_id`) VALUES ('3', 'alex', 'alex', '2');
INSERT INTO `task_manager_db`.`user` (`id`, `name`, `password`, `role_id`) VALUES ('4', 'mike', 'mike', '3');
INSERT INTO `task_manager_db`.`user` (`id`, `name`, `password`, `role_id`) VALUES ('5', 'jhon', 'jhon', '3');
INSERT INTO `task_manager_db`.`user` (`id`, `name`, `password`, `role_id`) VALUES ('6', 'tim', 'tim', '3');

INSERT INTO `task_manager_db`.`project` (`id`, `name`) VALUES ('1', 'first project');
INSERT INTO `task_manager_db`.`project` (`id`, `name`) VALUES ('2', 'second project');
INSERT INTO `task_manager_db`.`project` (`id`, `name`) VALUES ('3', 'my project');

INSERT INTO `task_manager_db`.`user_to_project` (`user_id`, `project_id`) VALUES ('2', '1');
INSERT INTO `task_manager_db`.`user_to_project` (`user_id`, `project_id`) VALUES ('2', '2');
INSERT INTO `task_manager_db`.`user_to_project` (`user_id`, `project_id`) VALUES ('3', '3');
INSERT INTO `task_manager_db`.`user_to_project` (`user_id`, `project_id`) VALUES ('3', '1');

INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `task_status_id`, `project_id`) VALUES ('1', 'start project', '2', '4', '1', '1');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `task_status_id`, `project_id`) VALUES ('2', 'new project', '3', '4', '1', '1');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `task_status_id`, `project_id`) VALUES ('3', 'enable', '2', '5', '2', '1');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `task_status_id`, `project_id`) VALUES ('4', 'good', '2', '6', '3', '2');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `task_status_id`, `project_id`) VALUES ('5', 'bad', '3', '4', '2', '2');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `task_status_id`, `project_id`) VALUES ('6', 'cat', '3', '5', '2', '2');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `task_status_id`, `project_id`) VALUES ('7', 'dog', '3', '4', '1', '2');
