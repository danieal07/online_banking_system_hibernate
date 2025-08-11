import React from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';
import './index.css';

function App() {
  const isLoggedIn = true;
  const showCourse = true;

  return (
    <div className="container">
      <BookDetails />
      <BlogDetails isLoggedIn={isLoggedIn} />
      <CourseDetails showCourse={showCourse} />
    </div>
  );
}

export default App;
