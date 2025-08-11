import React from 'react';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: []
    };
  }

  loadPosts() {
    const data = [
      { id: 1, title: "Post One", body: "This is the first post." },
      { id: 2, title: "Post Two", body: "This is the second post." },
      { id: 3, title: "Post Three", body: "This is the third post." }
    ];
    this.setState({ posts: data });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    console.error("Error occurred:", error, info);
  }

  render() {
    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map(post => (
          <div
            key={post.id}
            style={{
              border: '1px solid gray',
              padding: '10px',
              margin: '10px 0'
            }}
          >
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
