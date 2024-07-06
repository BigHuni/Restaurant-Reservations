INSERT INTO user (username, password, role) VALUES ('user1', '$2a$10$eB7kVpF.UzDpYdy1Jo2vMe8jcnlNwwkn9/ZyJzUlZab5KuMrkO7pS', 'USER'); -- password is 'password'
INSERT INTO user (username, password, role) VALUES ('owner', '$2a$10$eB7kVpF.UzDpYdy1Jo2vMe8jcnlNwwkn9/ZyJzUlZab5KuMrkO7pS', 'PARTNER'); -- password is 'password'

INSERT INTO store (name, location, description, owner_id) VALUES ('Store 1', 'Location 1', 'Description 1', 2);
INSERT INTO store (name, location, description, owner_id) VALUES ('Store 2', 'Location 2', 'Description 2', 2);