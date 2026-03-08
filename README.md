# Connect Four (Java)

A simple command-line **Connect Four** game written in **Java** (2 players).

## Rules
- Board is **6 rows x 7 columns**
- Players take turns dropping discs into a column:
  - Player 1: `X`
  - Player 2: `O`
- First to connect **4 in a row** wins:
  - Horizontal, vertical, or diagonal
- If the board fills up, it’s a draw.

## Controls
- Type a column number from `0` to `6`
- Type `q` to quit

## Project Structure
```text
connect-four-java/
├─ src/
│  ├─ Main.java
│  ├─ ConnectFourGame.java
│  └─ Board.java
├─ .gitignore
├─ LICENSE
└─ README.md