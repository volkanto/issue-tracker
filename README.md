# Simple Issue Tracker

A RESTful api and UI for simple issue tracking system.

## Features

- Developer add/delete operations
- Bug add/update/assign to developer operations
- Story add/update/assign to developer operations
- Sprint add/update

## Installation

- Clone repository with this command:
```bash
$ git clone git@github.com:volkanto/issue-tracker.git
```
- Import as maven project with your favorite IDE(I recommend Eclipse or STS) to your workspace
- Run maven update
- Open IssueTrackerApplication.java class
- Right click when you inside the related class file
- Choose run as Java Application or Spring Boot App
- You can reach via http://localhost:8080 from your favorite browser

## API methods

#### Developer
* Create new developer `/developer/create`  `POST`
    * Creates a new developer with given name
* Delete developer `/developer/{id}`  `DELETE`
    *
* Get developer information `/developer/{id}` `GET`
* Update developer `/developer/{id}` `PUT`
* List developers `/developer/list` `GET`

#### Bug
* Create new bug `/bug/create` `POST`
* Update bug `/bug/{id}` `PUT`
* Get bug information `/bug/{id}` `GET`
* List bugs `/bug/list` `GET`
* List unassigned bugs `/bug/unassigned/list` `GET`
* List bug statuses `/bug/status/list` `GET`
* Create new bug statuses `/bug/status/create` `POST`
* List bug priorities `/bug/priority/list` `GET`
* Create new bug priority `/bug/priority/create` `POST`
* Assign bugs to developer `/bug/{bugIds}/developer/{developerId}` `POST`

#### Story
* Create new Story `/story/create` `POST`
* Update story `/story/{id}` `PUT`
* List stories `/story/list` `GET`
* List unassigned stories `/story/unassigned/list` `GET`
* List story points `/story/point/list` `GET`
* List story statuses `/story/status/list` `GET`
* Assign stories to developer `/story/assign/{storyIds}/developer/{developerId}` `POST`

#### Sprint
* Create new sprint `/sprint/create` `POST`
* Update sprint `/sprint/{id}` `PUT`
* List sprints `/sprint/list` `GET`
* Get sprint information `/sprint/{id}` `GET`
* Assign stories to sprint `/sprint/{id}/assign/story/{storyIds}` `POST`

### Usage

After install, make sure to run `joe update`. This will download all `.gitignore` files in `~/joe-data/` folder.

## TO-DO's
* Use gulp for automate ui tasks
* add bower_components to gitignore

## Bug Reports & Feature Requests

Please use the [issue tracker](https://github.com/volkanto/issue-tracker/issues) to report any bugs or feature requests.
