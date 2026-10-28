
-- CueTrack Database Setup
CREATE DATABASE IF NOT EXISTS CueTrack;
USE CueTrack;

-- 1. Opponents Table
CREATE TABLE IF NOT EXISTS opponents (
    opponent_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,

    CONSTRAINT chk_opponent_name
        CHECK (
            TRIM(name) <> ''
            AND name NOT REGEXP '[0-9]'
        )
) ENGINE=InnoDB;

-- 2. Game Table
CREATE TABLE IF NOT EXISTS game (
    game_id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    opponent_id INT NOT NULL,
    result VARCHAR(10) NOT NULL,
    venue VARCHAR(45),
    table_size DECIMAL(3,1),
    cue_weight DECIMAL(4,1),
    scratches INT NOT NULL DEFAULT 0,
    longest_run INT NOT NULL DEFAULT 0,
    notes TEXT,

    CONSTRAINT chk_game_result
        CHECK (result IN ('Win', 'Loss')),

    CONSTRAINT chk_game_scratches
        CHECK (scratches >= 0),

    CONSTRAINT chk_game_longest_run
        CHECK (longest_run >= 0),

    CONSTRAINT fk_game_opponent
        FOREIGN KEY (opponent_id)
        REFERENCES opponents(opponent_id)

) ENGINE=InnoDB;

-- 3. Practice Session Table
CREATE TABLE IF NOT EXISTS practice_session (
    practice_id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    venue VARCHAR(45),
    table_size DECIMAL(3,1),
    cue_weight DECIMAL(4,1),
    duration INT NOT NULL,
    focus VARCHAR(100),
    scratches INT NOT NULL DEFAULT 0,
    longest_run INT NOT NULL DEFAULT 0,
    notes TEXT,

    CONSTRAINT chk_practice_duration
        CHECK (duration >= 0),

    CONSTRAINT chk_practice_scratches
        CHECK (scratches >= 0),

    CONSTRAINT chk_practice_longest_run
        CHECK (longest_run >= 0)

) ENGINE=InnoDB;

-- 4. Verify Info
SHOW TABLES;

DESCRIBE opponents;
DESCRIBE game;
DESCRIBE practice_session;