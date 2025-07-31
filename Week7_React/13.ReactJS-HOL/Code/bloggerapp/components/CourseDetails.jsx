export default function CourseDetails({ courses, onSelect }) {
  return (
    <div>
      <h1 style={{ fontSize: "24px", fontWeight: "bold" }}>All Courses</h1>
      <ul>
        {courses.map((course) => (
          <li key={course.id} style={{ marginBottom: "16px" }}>
            <h2>
              Course Name:{" "}
              <span style={{ fontWeight: "bold" }}>{course.title}</span>
            </h2>
            <p>Description: {course.description}</p>
            <button
              onClick={() => onSelect(course)}
              style={{
                padding: "10px 20px",
                backgroundColor: "#007bff",
                color: "#fff",
                border: "none",
                borderRadius: "4px",
                cursor: "pointer",
              }}
            >
              View Book & Blog
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}
