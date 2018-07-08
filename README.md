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
- register
- move
	- fromX
	- fromY
	- toX
	- toY

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

## ClientFeatures
- [ ] Connect
- [ ] Login
- [ ] Register
- [ ] Seach for Game
- [ ] Challange
- [ ] Show Replay
- [ ] Show Profile
- [ ] Ingame
- [ ] Logout

## ServerFeatures
- [x] Connect
- [x] Login
- [x] Register
- [ ] Seach for Game
- [ ] Challange
- [ ] Show Replay
- [ ] Show Profile
- [ ] Ingame
- [x] Logout
- [ ] CreateGame
