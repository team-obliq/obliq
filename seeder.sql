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
