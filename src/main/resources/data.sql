-- Franchise
INSERT INTO franchise ("name", "description")
VALUES ('Tolkien universe', 'Movies inspired by Tolkien books');
INSERT INTO franchise ("name", "description")
VALUES ('Marvel universe', 'Superhero stuff');
INSERT INTO franchise ("name", "description")
VALUES ('Harry Potter', 'Magic stuff');

-- Movies
INSERT INTO movie ("title", "director", "genre", "picture_url", "trailer_url", "year", "franchise_id")
VALUES ('Harry Potter and the Chamber of Secrets',
        'Chris Columbus',
        'Fantasy, Young Adult',
        'https://m.media-amazon.com/images/M/MV5BMjE0YjUzNDUtMjc5OS00MTU3LTgxMmUtODhkOThkMzdjNWI4XkEyXkFqcGdeQXVyMTA3MzQ4MTc0._V1_.jpg',
        'https://www.youtube.com/watch?v=jBltxS8HfQ4',
        2002,
        3);
INSERT INTO movie ("title", "director", "genre", "picture_url", "trailer_url", "year", "franchise_id")
VALUES ('Harry Potter and the Prisoner of Azkaban',
        'David Yales',
        'Fantasy, Young Adult',
        'https://m.media-amazon.com/images/M/MV5BMTY4NTIwODg0N15BMl5BanBnXkFtZTcwOTc0MjEzMw@@._V1_.jpg',
        'https://www.youtube.com/watch?v=1ZdlAg3j8nI',
        2004,
        3);
INSERT INTO movie ("title", "genre", "year")
VALUES ('Glass Onion: A Knives Out Mystery',
        'Comedy, Murder Mystery',
        2022);
INSERT INTO movie ("title", "year")
VALUES ('Everything Everywhere All at Once',
        2022);
INSERT INTO movie ("title", "year", "genre")
VALUES ('Inception',
        2010,
        'Sci-Fi, Adventure, Action');

-- Characters
INSERT INTO character ("full_name", "gender", "picture_url")
VALUES ('Harry Potter', 'Male', 'https://api.time.com/wp-content/uploads/2014/07/301386_full1.jpg');
INSERT INTO character ("full_name", "alias", "gender", "picture_url")
VALUES ('Tom Riddle', 'Voldemort', 'Non-binary',
        'https://static.wikia.nocookie.net/harrypotter/images/d/d1/Voldemort_Info.jpg/revision/latest?cb=20130703134443&path-prefix=de');
INSERT INTO character ("full_name")
VALUES ('Benoit Blanc');

-- Movie character
INSERT INTO movie_character ("movie_id", "character_id")
VALUES (1, 1);
INSERT INTO movie_character ("movie_id", "character_id")
VALUES (1, 2);
INSERT INTO movie_character ("movie_id", "character_id")
VALUES (2, 1);
INSERT INTO movie_character ("movie_id", "character_id")
VALUES (2, 2);
INSERT INTO movie_character ("movie_id", "character_id")
VALUES (3, 3);
