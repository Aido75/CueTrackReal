-- CueTrack Clear Data
USE CueTrack;

-- 1. Remove Game Data
DELETE FROM game;

-- 2. Remove Practice Session Data
DELETE FROM practice_session;

-- 3. Remove Opponent Data
DELETE FROM opponents;

-- 4. Verify Info
SELECT * FROM opponents;
SELECT * FROM game;
SELECT * FROM practice_session;