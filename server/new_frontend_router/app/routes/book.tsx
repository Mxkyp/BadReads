import type { Route } from "./+types/home";
import BookPage from "../discover/page.tsx"

export function meta({}: Route.MetaArgs) {
  return [
    { title: "Book" },
    { name: "description", content: "Discover your new favourite book!" },
  ];
}

export default function Book() {
  return <BookPage/>;
}
