# health-tracker-backend
Server for [Health Tracker Application](https://github.com/JessLovell/health-tracker) 

## API Routes
Route | Description | Request Type
--- | --- | ----
`/exercises` | Get | This route will return all the exercise entries in the db.
`/exercises` | Post | This route will create an exercise instance in the db and return that instance.
`/signup` | Post | This route will sign a user up and log them in. The body requires a `username`, `password`, `firstName`, `lastName`, `dateOfBirth`.
`/perform_login` | Post | This route will login a user. Requires `username` and `password` in the request body.

## Resources
- [Gson](https://github.com/google/gson)

## [Deployed Server](https://stormy-bayou-86086.herokuapp.com)
