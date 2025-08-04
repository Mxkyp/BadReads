export function Input({ ...props }) {
  return (
    <input
      className="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring focus:border-blue-300"
      {...props}
    />
  );
}
