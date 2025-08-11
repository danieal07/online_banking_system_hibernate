import React from 'react';

function CourseDetails({ showCourse }) {
  return (
    <div className="mystyle1">
      <h1>Course Details</h1>
      {showCourse ? (
        <ul>
          <li>Full Stack Development</li>
          <li>Data Science with Python</li>
          <li>React Native for Mobile</li>
        </ul>
      ) : (
        <p>Courses are not available right now.</p>
      )}
    </div>
  );
}

export default CourseDetails;
