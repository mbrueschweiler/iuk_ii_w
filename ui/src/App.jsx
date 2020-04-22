import React from 'react';

import logo from './book.svg';
import Books from "./book/Books.jsx"
import CreateBook from "./book/CreateBook.jsx";
import './App.css';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from 'react-router-dom';

function App() {
    return (
        <div className="App">
            <Router>
                <header className="App-header">
                    <h1>Booksstore</h1>
                    <img src={logo} className="App-logo" alt="logo" />
                    <p>Welcome to our Book store.</p>
                    <nav>
                        <Link to='/'>Home</Link> | <Link to='/books'>Books</Link> | <Link to='/create'>Create Book</Link>
                    </nav>
                </header>
                <Switch>
                    <Route path="/books">
                        <Books/>
                    </Route>
                    <Route path="/create">
                        <CreateBook/>
                    </Route>
                    <Route path="/">
                        <p>Home Komponente bauen...</p>
                    </Route>
                </Switch>
            </Router>
        </div>
    );
}

export default App;