import React from 'react';
import Book from './Book.jsx'

class Books extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            books: []
        };
    }
    componentDidMount() {
        fetch('api/books')
            .then((response => {
                return response.json();
            }))
            .then(data => {
                this.setState({
                    books:data
                })
            });
    }
    render() {
        return (
            <section>
                {
                    this.state.books.length > 0 ?
                        this.state.books.map(function (book ) {
                            return (<Book key={book.id} book={book}/>);
                        }): null
                }
            </section>
        );
    }
}

export default Books;