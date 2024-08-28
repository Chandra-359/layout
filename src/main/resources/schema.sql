-- Create the Layout table
CREATE TABLE IF NOT EXISTS layout (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

-- Create the User table (escaping the table name)
CREATE TABLE IF NOT EXISTS "user" (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create the UserGroup table
CREATE TABLE IF NOT EXISTS user_group (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- Create the UserGroup-User join table
CREATE TABLE IF NOT EXISTS user_group_users (
    user_group_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    PRIMARY KEY (user_group_id, user_id),
    FOREIGN KEY (user_group_id) REFERENCES user_group(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES "user"(id) ON DELETE CASCADE
);

-- Create the UserLayoutAssignment table
CREATE TABLE IF NOT EXISTS user_layout_assignment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    user_group_id BIGINT,
    layout_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES "user"(id),
    FOREIGN KEY (user_group_id) REFERENCES user_group(id),
    FOREIGN KEY (layout_id) REFERENCES layout(id)
);
