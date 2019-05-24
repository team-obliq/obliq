use obliq_db;

INSERT INTO users (username, email, password, first_name, bio, continent, points, tribe_id, career_id, date_created)
VALUES
('travis', 'travis@travis.com', 'travis', 'travis', 'this is my bio', 1, 0, 1,  2, CURRENT_DATE );

INSERT INTO users (username, email, password, first_name, bio, continent, points, tribe_id, career_id, date_created)
VALUES
('carlo', 'carlo@carlo.com', 'carlo', 'carlo', 'this is carlos bio', 1, 0 , 2, 1, current_date );

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
(CURRENT_DATE, 'this is the comment body for comment #3', 1, 1, 1);


INSERT INTO card (card_name)
values
('Remove specifics and convert to ambiguities'),
('Think of the Radio'), ('Dont be frightened of cliches'),
('Allow an easement'),('What is the reality of the situation?'),
('Simple Subtraction'), ('Are there sections? Consider transitions'),
('Turn it upside down'),
('Go slowly all the way round the outside'),('A line has two sides'),
('Infinitesimal gradations'), ('Make an exhaustive list of everything you might do and do the last thing on the list'),
('Change instrument roles'),( 'Into the impossible'), ('Accretion'),
('Ask people to work against their better judgement'),('Disconnect from desire'),
('Take away the elements in order of apparent non-importance'),('Emphasize repetitions'),
('Dont be afraid of things because theyre easy to do'),('Is there something missing?'),
('Dont be frightened to display your talents'),('Use unqualified people'),
('Breathe more deeply'),('How would you have done it?'),('Honor thy error has hidden intention'),
('Emphasize differences'),('Only one element of each kind'),('Do nothing for as long as possible'),
('Bridges: build, burn'),('Water'),('You dont have to be ashamed of using your own ideas'),
('Make a sudden, destructive unpredictable action; incorporate'),
('Tidy up'),('Consult other sources'),('Do the words need changing?'),
('Use an unacceptable color'),('Ask your body'),('Humanize something free of error'),
('Use filters'),('Balance the consistency principle with the inconsistency principle'),
('Fill every beat with something'),('Discard an axiom'),('Listen to the quiet voice'),
('What wouldnt you do?'),('Is it finished?'),('Decorate, decorate'),('Put in earplugs'),
('Give the game away'),('Reverse'),('Abandon normal instruments'),('Trust in the you of now'),
('Use fewer notes'),('What would your closest friend do?'),('Repetition is a form of change'),
('Distorting time'),('Give way to your worst impulse'),('Make a blank valuable by putting in an exquisite frame'),
('Blankness'),('The inconsistency principle'),('Ghost echoes'),
('Dont break the silence'),('You can only make one dot at a time'),
('Discover the recipes you are using & abandon them'),('Just carry on'),
('Cascades'),('(Organic) machinery'),('Courage!'),('What mistakes did you make last time?'),
('You are an engineer'),('Consider different fading systems'),('Remove ambiguities and convert to specifics'),
('Mute and continue'),('Look at the order in which you do things'),
('It is quite possible(after all)'),('Go outside. Shut the door'),
('Dont stress one thing more than another'),('Do we need holes'),
('Cluster analysis'),('Work at a different speed'),('Do something boring'),('Look closely at the most embarrassing details and amplify them'),
('Define an area as safe and use it as an anchor'),('Mechanicalize something idiosyncratic'),
('Overly resist change'),('Emphasize the flaws'),('Accept Advice'),('Remember those quiet evenings'),
('Take a break'),('The tape is now the music'),('Short Circuit: (example; a man eating peas with the idea that they will improve his virility shovels them straight into his lap'),
('Imagine the music as a moving chain or caterpillar'),('Use an old idea'),
('Intentions: credibility of, nobility of, humility of'),('Destroy: nothing, the most important thing'),
('Change nothing and continue with immaculate consistency'),('Imagine the music as a set of disconnected events'),
('Imagine the piece as a set of disconnected events'),('What are you really thinking about just now? Incorporate'),
('Childrens voices: speaking, singing'),('Assemble some of the instruments in a group and treat the group'),
('Feedback recordings into an acoustic situation'),('Shut the door and listen from outside'),
('Towards the insignificant'),('Is the tuning appropriate?'),('Simply a matter of work'),
('Look at a very small object, look at its center'),('Not building a wall but making a brick'),
('Re-evaluation(a warm feeling)'),('Disciplined self-indulgence'),
('The most important thing is the thing most easily forgotten'),('Always first steps'),
('Idiot glee'),('Question the heroic approach'),('Be extravagant'),
('Always give yourself credit for having more personality'),('State the problems in words as clear as possible'),
('Faced with choice, do both'),('Tape your mouth'),('Twist the spine'),
('Get your neck massaged'),('Lowest common denominator check: single beat, single note, single riff'),
('Do the washing up'),('Listen in total darkness, or in a very large room, very quietly'),
('Convert a melodic element into a rhythmic element'),('Would anybody want it?'),
('Spectrum analysis'),('Retrace your steps'),('Go to an extreme, move back to the more comfortable place'),
('Once the search is in the progress, something will be found'),('Only a part, not the whole'),
('From nothing to more than nothing'),('Be less critical more often');

INSERT INTO users (username, email, password, first_name, bio, continent, points, tribe_id, career_id, date_created)
values ('MinaMoon', 'mina@mina.com', 'mina', 'Mina', 'My name is Mina and I am a user', 'Africa', 0, 1, 1,
        current_date),
       ('JesseRune', 'jesse@jess.com', 'jesse', 'Jesse', 'My name is Jesse & I am not a user', 'Australia', 0, 1, 1,
        current_date),
       ('MarshaTizzo', 'marsha@marsha.com', 'marsha', 'Marsha', 'My name is Marsha, I dont care', 'United States', 0, 1,
        1, current_date),
       ('RoamByaz', 'roam@roam.com', 'roam', 'Roam', 'I roam and thats it', 'Europe', 0, 1, 1, current_date),
       ('ClydeDina', 'clyde@clyde.com', 'clyde', 'Clyde', 'My name is Clyde, thats all', 'Africa', 0, 1, 1,
        current_date),
       ('MagentaPatriot', 'magenta@magenta.com', 'magenta', 'Magenta', 'Magenta is my name', 'South America', 0, 1, 4,
        current_date),
       ('CyanMyst', 'myst@cyan.com', 'myst', 'Cyan', 'My name is an island - Myst', 'United States', 0, 1, 4,
        current_date),
       ('NadiaGeorgino', 'nadia@sheila.com', 'nadia', 'Nadia', 'Nadia is my name yo', 'Asia', 0, 1, 4, current_date),
       ('MaroonAcme', 'maroon@acme.com', 'maroon', 'Maroon', 'Acme Brick Company - Maroon', 'Australia', 0, 1, 4,
        current_date);


INSERT INTO careers(title)
values ('Doctor'),
       ('Programmer'),
       ('Astrologist'),
       ('Nutritionist'),
       ('Archaeologist'),
       ('Architect'),
       ('Writer'),
       ('Cage Fighter'),
       ('Painter'),
       ('Teacher');

INSERT INTO comments (date_created, body, points, post_id, user_id)
VALUES (current_date,'this is Minas comment',0,1,1),
       (current_date,'this is Maroons comment',0,2,2),
       (current_date, 'this is Magentas comment', 0, 3, 3),
       (current_date, 'this is Roams comment',0,4,4),
       (current_date, 'This Clydes comment',0,5,5),
       (current_date, 'This is Jesses comment', 0,6,6),
       (current_date, 'This is Marshas comment', 0,7,7),
       (current_date, 'This is Nadias comment', 0,8,8),
       (current_date, 'This is Cyans comment', 0,9,9);

INSERT INTO posts (title, body, date_created, user_id)
VALUES ('Minas gonna Mean', 'Mina cant choose what color for her room', current_date, 1),
       ('Maroon Acme rises Again', 'How come my bricks keep failing?', current_date, 2),
       ('Magenta is no color at all!', 'Magenta needs more clarity on her problem', current_date, 3),
       ('Roam is gonna Roam - thats it', 'Roam has had it with Peanuts - who can help?', current_date, 4),
       ('Clyde doesnt belong here', 'Clyde cant get this paint to mix', current_date, '5'),
       ('Jesse doesnt play that', 'Homie literally doesnt play that', current_date, '6'),
       ('Marsha is not a Warfield', 'The warfield is my home & Im having a hard time adjusting', current_date, 7),
       ('Nadia is in control of everything', 'How can I relinquish control more?',current_date, 8)
       ('Cyan thinks Myst is awesome', 'Did I tell you the game Myst is awesome - how is it not awesome?', current_date, 9);

INSERT INTO users (username, email, password, first_name, bio, continent, points, tribe_id, career_id, date_created)
VALUES ('Triphone X', 'triphone@iphone.com', 'triphone', 'Triphone', 'My name is Triphone X', 'Asia', 0, 1, 2,current_date);

INSERT INTO posts (title, body, date_created, user_id)
VALUES ('Triphone is going to Try', 'I need help switching to Android', current_date, 10);

INSERT INTO comments (date_created, body, points, post_id, user_id)
VALUES (current_date, 'further comment: android sucks', 0, 4,10);



