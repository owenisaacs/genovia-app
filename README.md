Welcome to Helios X Genovia

Please clone the repo and run GenoviaAppApplication to start the Spring Application

There are two endpoints requests:

curl --location 'http://localhost:8080/consultations/questions'

This returns the questions to be displayed to the front end for user's to answer

curl --location 'http://localhost:8080/consultations/answers' \
--header 'Content-Type: application/json' \
--data '[
    {
        "question": {
            "question": "Are you feeling symptoms?",
            "mandatory": false,
            "score": 10
        },
        "response": "Yes"
    },
    {
        "question": {
            "question": "Have you been prescribed by a GP?",
            "mandatory": true,
            "score": 0
        },
        "response": "no"
    },
    {
        "question": {
            "question": "Have you ordered with Genovia Helios X before?",
            "mandatory": false,
            "score": 12
        },
        "response": "no"
    }
]'

This example request uses the questions stored in memory in the app and returns a boolean response true or false on whether we would prescribe for this patient's consultation. 

We have also added a threshold for likeliness based on the score added on each question answers positively

E.g, the above response will return:

{
    "prescriptionDescision": true,
    "likeliness": "LOW"
}

Likeliness will be NONE if prescriptionDescision is false based on a mandatory question being answered negatively.
