"use client";

import React from "react";

class Post {
  constructor(id, title, body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }
}

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  loadPosts = () => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => response.json())
      .then((data) => {
        const postObjects = data.map((p) => new Post(p.id, p.title, p.body));
        this.setState({ posts: postObjects });
      })
      .catch((error) => {
        console.error("Error fetching posts:", error);
      });
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    console.error("Error occurred:", error);
    console.error("Error info:", info);
  }

  render() {
    return (
      <div>
        {this.state.posts.length > 0 ? (
          this.state.posts.map((post) => (
            <div key={post.id} className="mb-4 p-4 border rounded shadow">
              <h2 className="text-lg font-bold">{post.title}</h2>
              <p className="text-base font-normal">{post.body}</p>
            </div>
          ))
        ) : (
          <p>Loading posts...</p>
        )}
      </div>
    );
  }
}

export default Posts;
