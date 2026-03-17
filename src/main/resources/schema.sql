CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    roles VARCHAR(255)
);

-- Insert a standard user
INSERT INTO users (username, password, roles)
VALUES ('alice_springs', 'password123', 'ROLE_USER');

-- Insert an administrator
INSERT INTO users (username, password, roles)
VALUES ('admin_bob', 'secure_admin_pass', 'ROLE_ADMIN');

-- Insert a user with multiple roles (comma-separated as per your comment)
INSERT INTO users (username, password, roles)
VALUES ('charlie_dev', 'dev_pass_2026', 'ROLE_USER,ROLE_ADMIN');

-- Insert a guest user
INSERT INTO users (username, password, roles)
VALUES ('guest_viewer', 'guest_only', 'ROLE_GUEST');