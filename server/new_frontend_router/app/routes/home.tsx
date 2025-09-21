import type { Route } from "./+types/home";
import Landing from "../landing/landing";

export function meta({}: Route.MetaArgs) {
  return [
    { title: "BadReads" },
    { name: "description", content: "Welcome to BadReads!" },
  ];
}

export default function Home() {
  return <Landing />;
}
