export default function BookDetails({ book }) {
  if (!book) return <p>No book found.</p>;

  return (
    <div>
      <h3 style={{ fontWeight: "bold" }}>Recommended Book</h3>
      <p>
        <strong>Title:</strong> {book.title}
      </p>
      <p>
        <strong>Author:</strong> {book.author}
      </p>
    </div>
  );
}
