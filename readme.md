🎮 ESports Tournament Management System

A Spring Boot REST API for managing esports tournaments.

This project was developed as part of the Endterm Project and follows OOP principles, SOLID design, and Layered Architecture.

🚀 Features

The system allows management of:

🎮 Games

👥 Teams

🧑 Players

🏆 Tournaments

⚔ Matches

Supported operations:

✅ Create

✅ Read (All / By ID)

✅ Update

✅ Delete

🏗 Project Architecture

The application follows a layered architecture:

controller   → REST API endpoints
service      → business logic
repository   → data access layer
model        → domain entities
dto          → data transfer objects
builder      → Builder pattern implementation
singleton    → ID generation
exception    → global REST error handling

🧠 Design Patterns Used

🔹 Builder Pattern
Used to construct domain objects (PlayerBuilder, TeamBuilder, MatchBuilder, TournamentBuilder).

🔹 Singleton Pattern
Used for centralized ID generation (IdGenerator).

🔹 DTO Pattern
Separates internal domain models from external API representation.

🔹 Layered Architecture
Controller → Service → Repository separation.

🔹 Global Exception Handling
Centralized REST error handling using @RestControllerAdvice.

🗂 Main Entities

🎮 Game

* id
* name
* genre
* teamSize 


👥 Team

* id
* name
* playerIds (list of player IDs)

🧑 Player

* id
* nickname
* age
* rank
* teamId

🏆 Tournament

* id
* name
* gameId
* 
⚔ Match

* id
* teamAId
* teamBId
* scoreA
* scoreB
* tournamentId

🔄 API Endpoints

**Players**
* POST    /api/players
* GET     /api/players
* GET     /api/players/{id}
* PUT     /api/players/{id}
* DELETE  /api/players/{id}

**Teams**
* POST    /api/teams
* GET     /api/teams
* GET     /api/teams/{id}
* PUT     /api/teams/{id}
* DELETE  /api/teams/{id}

**Tournaments**
* POST    /api/tournaments
* GET     /api/tournaments
* GET     /api/tournaments/{id}
* PUT     /api/tournaments/{id}
* DELETE  /api/tournaments/{id}

**Matches**
* POST    /api/matches
* GET     /api/matches
* GET     /api/matches/{id}
* PUT     /api/matches/{id}
* DELETE  /api/matches/{id}

🛠 Technologies Used

* Java 21+
* Spring Boot
* REST API
* Maven
* Postman (for testing)

▶ How to Run

1. Clone the repository:
3. git clone <repository-url>
6. Open the project in IntelliJ IDEA.
8. Run the main class: EndtermESportsIrtayAldiyarApplication
13. Test endpoints using Postman: http://localhost:8080/api/...

🧪 Example JSON Request (Create)
Game:
{
"name": "CS2",
"type": "FPS"
}

Player:
{
"nickname": "bobo",
"age":23,
"rank":7,
"team_id":2
}


Matches:
{
"teamAId": 1,
"teamBId": 2,
"tournamentId": 4
}

Tournaments:
{
"name": "Major Championship 2026",
"gameId": 1
}

Teams:
{
"name": "NAVI",
"country": "Ukraine"
}
x



**This project demonstrates:**

Object-Oriented Programming principles

Clean code structure

Proper separation of concerns

RESTful API design

Use of design patterns

Error handling best practices