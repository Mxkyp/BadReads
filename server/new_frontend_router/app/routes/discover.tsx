import type { Route } from "./+types/home";
import  DiscoverPage from "../discover/discoverPage";

export function meta({}: Route.MetaArgs) {
  return [
    { title: "Discover" },
    { name: "description", content: "Discover your new favourite book!" },
  ];
}

export default function Discover() {
  return <DiscoverPage />;
}
