INSERT INTO users (username, email, password, first_name, bio, continent, tribe_id, career_id, date_created)
VALUES
('travis', 'travis@travis.com', 'travis', 'travis', 'this is my bio', 1, 1, 2, CURRENT_DATE );

INSERT INTO users (username, email, password, first_name, bio, continent, tribe_id, career_id, date_created)
VALUES
('carlo', 'carlo@carlo.com', 'carlo', 'carlo', 'this is carlos bio', 1, 2, 1, current_date );

INSERT INTO posts (title, body, date_created, user_id)
values
('Post #1', 'This is post #1', CURRENT_DATE, 1);

INSERT INTO posts (title, body, date_created, user_id)
values
('Post #3', 'This is post #3', CURRENT_DATE, 1);

INSERT INTO posts (title, body, date_created, user_id)
values
('Post #3', 'This is post #3', CURRENT_DATE, 2);


INSERT INTO comments (date_created, body, points, post_id, user_id)
values 
(current_date, 'This is the body of the comment', 1, 1, 2);

INSERT INTO comments (date_created, body, points, post_id, user_id)
values 
(CURRENT_DATE, 'this is the comment body', 1, 2, 1);

INSERT INTO comments (date_created, body, points, post_id, user_id)
values 
(CURRENT_DATE, 'this is the comment body for comment #3', 1, 3, 1);


