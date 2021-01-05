INSERT INTO `task_manager_db`.`user` (`id`, `name`, `password`, `role`) VALUES ('2', 'tolik', 'tolik', 'manager');
INSERT INTO `task_manager_db`.`user` (`id`, `name`, `password`, `role`) VALUES ('3', 'alex', 'alex', 'manager');
INSERT INTO `task_manager_db`.`user` (`id`, `name`, `password`, `role`) VALUES ('4', 'mike', 'mike', 'executor');
INSERT INTO `task_manager_db`.`user` (`id`, `name`, `password`, `role`) VALUES ('5', 'jhon', 'jhon', 'executor');
INSERT INTO `task_manager_db`.`user` (`id`, `name`, `password`, `role`) VALUES ('6', 'tim', 'tim', 'executor');

INSERT INTO `task_manager_db`.`project` (`id`, `name`) VALUES ('1', 'first project');
INSERT INTO `task_manager_db`.`project` (`id`, `name`) VALUES ('2', 'second project');
INSERT INTO `task_manager_db`.`project` (`id`, `name`) VALUES ('3', 'my project');

INSERT INTO `task_manager_db`.`user_to_project` (`user_id`, `project_id`) VALUES ('2', '1');
INSERT INTO `task_manager_db`.`user_to_project` (`user_id`, `project_id`) VALUES ('2', '2');
INSERT INTO `task_manager_db`.`user_to_project` (`user_id`, `project_id`) VALUES ('3', '3');
INSERT INTO `task_manager_db`.`user_to_project` (`user_id`, `project_id`) VALUES ('3', '1');

INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `status`, `project_id`) VALUES ('1', 'start project', '2', '4', 'start', '1');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `status`, `project_id`) VALUES ('2', 'new project', '3', '4', 'start', '1');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `status`, `project_id`) VALUES ('3', 'enable', '2', '5', 'execute', '1');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `status`, `project_id`) VALUES ('4', 'good', '2', '6', 'finish', '2');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `status`, `project_id`) VALUES ('5', 'bad', '3', '4', 'execute', '2');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `status`, `project_id`) VALUES ('6', 'cat', '3', '5', 'execute', '2');
INSERT INTO `task_manager_db`.`task` (`id`, `name`, `owner_id`, `executor_id`, `status`, `project_id`) VALUES ('7', 'dog', '3', '4', 'start', '2');
