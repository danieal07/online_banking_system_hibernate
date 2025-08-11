// src/Posts.js
import React from "react";
import Post from "./Post";

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            hasError: false
        };
    }

    loadPosts() {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then(response => response.json())
            .then(data => {
                const postObjects = data.map(item => new Post(item.id, item.title, item.body));
                this.setState({ posts: postObjects });
            })
            .catch(error => {
                this.setState({ hasError: true });
                console.error("Error loading posts:", error);
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    render() {
        if (this.state.hasError) {
            return <h2>Something went wrong while loading posts.</h2>;
        }

        return (
            <div>
                <h1>Blog Posts</h1>
                {this.state.posts.map(post => (
                    <div key={post.id} style={{ marginBottom: "20px" }}>
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }

    componentDidCatch(error, info) {
        this.setState({ hasError: true });
        alert("An error occurred in the Posts component.");
        console.error("Error caught in componentDidCatch:", error, info);
    }
}

export default Posts;
