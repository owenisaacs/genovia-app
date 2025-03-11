Welcome to Helios X Genovia

Please clone the repo and run GenoviaAppApplication to start the Spring Application

There are two endpoints requests:

curl --location 'http://localhost:8080/consultations/questions'

This returns the questions to be displayed to the front end for user's to answer

curl --location 'http://localhost:8080/consultations/answers' \
--header 'Content-Type: application/json' \
--data '[
        {
            "question": "Are you feeling symptoms?",
            "answer": "Yes"
        },
        {
            "question": "Do you want a prescription?",
            "answer": "Yes"
        }
]
'

This example request uses the questions stored in memory in the app and returns a boolean response true or false on whether we would prescribe for this patient's consultation. 

E.g, the above response will return:

{
    "prescriptionDescision": true
}

since all answers were "Yes". In this instance of the application, we are assuming any negative answer to a question will make a prescription unlikely. This can be extended in future.
