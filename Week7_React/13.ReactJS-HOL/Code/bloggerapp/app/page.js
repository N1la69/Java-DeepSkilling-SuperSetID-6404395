"use client";

import BlogDetails from "@/components/BlogDetails";
import BookDetails from "@/components/BookDetails";
import CourseDetails from "@/components/CourseDetails";
import { useState } from "react";

const courses = [
  { id: 1, title: "React Basics", description: "Learn the basics of React." },
  { id: 2, title: "Advanced React", description: "Dive deeper into React." },
  { id: 3, title: "React Hooks", description: "Understand React Hooks." },
  {
    id: 4,
    title: "Angular Basics",
    description: "Learn the basics of Angular.",
  },
  {
    id: 5,
    title: "Angular Advanced",
    description: "Dive deeper into Angular.",
  },
  { id: 6, title: "Vue Basics", description: "Learn the basics of Vue." },
  { id: 7, title: "Vue Advanced", description: "Dive deeper into Vue." },
];

const books = [
  { id: 1, title: "React for Beginners", author: "John Doe" },
  { id: 2, title: "Advanced React Patterns", author: "Jane Smith" },
  { id: 3, title: "Learning Vue.js", author: "Alice Johnson" },
  { id: 4, title: "Mastering Angular", author: "Bob Brown" },
];

const blogs = [
  {
    id: 1,
    title: "Understanding React",
    author: "Alice Smith",
    content: "This blog post covers the basics of React.",
  },
  {
    id: 2,
    title: "Advanced React Techniques",
    author: "Bob Johnson",
    content: "This blog post dives into advanced techniques in React.",
  },
  {
    id: 3,
    title: "Getting Started with Vue",
    author: "Charlie Brown",
    content: "This blog post introduces Vue.js and its features.",
  },
  {
    id: 4,
    title: "Angular for Beginners",
    author: "Diana White",
    content: "This blog post explains the fundamentals of Angular.",
  },
];

const App = () => {
  const [selectedCourse, setSelectedCourse] = useState(null);

  const getRelevant = (collection, courseTitle) => {
    const keyword = courseTitle.split(" ")[0];
    return collection.find((item) => item.title.includes(keyword));
  };

  return (
    <div
      style={{
        padding: 20,
        display: "flex",
        flexDirection: "row",
        gap: "20px",
      }}
    >
      <div>
        <CourseDetails courses={courses} onSelect={setSelectedCourse} />
      </div>

      {selectedCourse && (
        <div
          style={{
            marginLeft: 40,
            borderLeft: "1px solid #ccc",
            paddingLeft: 20,
            gap: "20px",
            display: "flex",
            flexDirection: "column",
          }}
        >
          <h2 style={{ fontWeight: "bold" }}>
            Selected Course: {selectedCourse.title}
          </h2>

          <BookDetails book={getRelevant(books, selectedCourse.title)} />
          <BlogDetails blog={getRelevant(blogs, selectedCourse.title)} />
        </div>
      )}
    </div>
  );
};

export default App;
