import React from 'react';
import './Book.css'

class CreateBook extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: ""
        };
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleSubmit(event) {
        alert('Create book with title "'+this.state.title+"'...implement fetch POST");
        event.preventDefault();
    }
    handleInputChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState( {
            [name]: value
        })
    }
    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                    Title:
                    <input type="text" name="title" value={this.state.title}
                        onChange={this.handleInputChange}
                    />
                </label>
                <input type="submit" value="Create Book" />
            </form>
        );
    }
}

export default CreateBook;