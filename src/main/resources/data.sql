-- Populate Layout table
INSERT INTO layout (name, description) VALUES ('Default Layout', 'The default layout for all users');
INSERT INTO layout (name, description) VALUES ('Admin Layout', 'A special layout for administrators');
INSERT INTO layout (name, description) VALUES ('Custom Layout', 'A customizable layout for advanced users');

-- Populate User table (escaping the table name)
INSERT INTO "user" (username, password) VALUES ('admin', '{noop}password');
INSERT INTO "user" (username, password) VALUES ('user1', '{noop}password');
INSERT INTO "user" (username, password) VALUES ('user2', '{noop}password');

-- Populate UserGroup table
INSERT INTO user_group (name) VALUES ('Admin Group');
INSERT INTO user_group (name) VALUES ('User Group 1');

-- Populate UserGroup-User join table
INSERT INTO user_group_users (user_group_id, user_id) VALUES (1, 1);  -- Admin in Admin Group
INSERT INTO user_group_users (user_group_id, user_id) VALUES (2, 2);  -- user1 in User Group 1
INSERT INTO user_group_users (user_group_id, user_id) VALUES (2, 3);  -- user2 in User Group 1

-- Populate UserLayoutAssignment table
INSERT INTO user_layout_assignment (user_id, layout_id) VALUES (1, 2);  -- Admin has Admin Layout
INSERT INTO user_layout_assignment (user_id, layout_id) VALUES (2, 1);  -- user1 has Default Layout
INSERT INTO user_layout_assignment (user_id, layout_id) VALUES (3, 3);  -- user2 has Custom Layout
