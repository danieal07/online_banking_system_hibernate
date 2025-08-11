import React from 'react';

function BlogDetails({ isLoggedIn }) {
  let content;

  if (isLoggedIn) {
    content = (
      <div>
        <p>Welcome Blogger! Here are your latest posts:</p>
        <ul>
          <li>React vs Angular</li>
          <li>10 Tips for Clean Code</li>
          <li>JavaScript Best Practices</li>
        </ul>
      </div>
    );
  } else {
    content = <p>Please log in to view blog details.</p>;
  }

  return (
    <div className="v1">
      <h1>Blog Details</h1>
      {content}
    </div>
  );
}

export default BlogDetails;
