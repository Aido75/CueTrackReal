-- CueTrack Dummy Data
USE CueTrack;

-- 1. Opponent Data
INSERT INTO opponents (name)
VALUES ('Andrew');

SET @opponent_id = LAST_INSERT_ID();

-- 2. Game Data
INSERT INTO game (
    date,
    opponent_id,
    result,
    venue,
    table_size,
    cue_weight,
    scratches,
    longest_run,
    notes
)
VALUES (
    '2026-11-25',
    @opponent_id,
    'Win',
    'Players Billiards',
    7.0,
    21.0,
    2,
    4,
    'Good game.'
);

-- 3. Practice Session Data
INSERT INTO practice_session (
    date,
    venue,
    table_size,
    cue_weight,
    duration,
    focus,
    scratches,
    longest_run,
    notes
)
VALUES (
    '2026-11-25',
    'Players Billiards',
    7.0,
    21.0,
    30,
    'Cue ball control',
    1,
    5,
    'Good practice.'
);

-- 4. Verify Info
SELECT * FROM opponents;
SELECT * FROM game;
SELECT * FROM practice_session;