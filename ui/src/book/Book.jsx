import React from 'react';
import './Book.css'

class Book extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
        };
    }
    render() {
        return (
            <section className="book">
                <h1>{this.props.book.title}</h1>
                <p>{this.props.book.description}</p>
            </section>
        );
    }
}

export default Book;