export default function BlogDetails({ blog }) {
  if (!blog) return <p>No blog found.</p>;

  return (
    <div>
      <h3 style={{ fontWeight: "bold" }}>Recommended Blog</h3>
      <p>
        <strong>Title:</strong> {blog.title}
      </p>
      <p>
        <strong>Author:</strong> {blog.author}
      </p>
      <p>{blog.content}</p>
    </div>
  );
}
