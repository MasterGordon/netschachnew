# Network Schach Rework

## Actions
Aufbau
- PACKET
	- KEY1
		- POSSIBLEVALUE1
		- POSSIBLEVALUE2
	- KEY2
		- POSSIBLEVALUE1
		- POSSIBLEVALUE2

#### From Client
- login
- logout
- register
- move
	- fromX
	- fromY
	- toX
	- toY
- acceptchallenge
	- who
- challenge
	- who

#### From Server
- loginerror
	- type:
		- invalidusername
		- invalidpassword
- registererror
	- type:
		- invalidusername
		- usernametaken
- moveerror
- loginsuccess
- registersuccess
- boardinit
	- color
		- white
		- black
	- board
- boardupdate
	- current
		- white
		- black
	- board
	- lastX
	- lastY
- gameover
	- replayid
	- winner
	- newelo
- challenge
	- who
- useroffline

## ClientFeatures
- [x] Connect
- [x] Login
- [x] Register
- [ ] Seach for Game
- [ ] Challenge
- [ ] Show Replay
- [ ] Show Profile
- [ ] Ingame
- [x] Logout

## ServerFeatures
- [x] Connect
- [x] Login
- [x] Register
- [ ] Seach for Game
- [x] Challange
- [ ] Show Replay
- [ ] Show Profile
- [x] Ingame
- [x] Logout
- [x] CreateGame
