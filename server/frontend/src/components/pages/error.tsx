import { Link } from "react-router";

export default function ErrorPage({ code, title, description }) {
  return (
    <>
      <main className="grid min-h-full place-items-center bg-white px-6 py-24 sm:py-32 lg:px-8">
        <div className="text-center">
          <p className="text-base font-semibold text-[var(--color-dark)]">{code}</p>
          <h1 className="mt-4 text-5xl font-semibold tracking-tight text-balance text-gray-900 sm:text-7xl">
          {title} 
          </h1>
          <p className="mt-6 text-lg font-medium text-pretty text-gray-500 sm:text-xl/8">
          {description}
          </p>
          <div className="mt-10 flex items-center justify-center gap-x-6">
            <Link
              to="/"
              className="rounded-md bg-[var(--color-dark)] px-3.5 py-2.5 text-sm font-semibold text-white shadow-xs hover:bg-[var(--color-medium)] focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-[var(--color-dark)]"
            >
              Go back home
            </Link>
            <a href="#" className="text-sm font-semibold text-gray-900">
              Contact support <span aria-hidden="true">&rarr;</span>
            </a>
          </div>
        </div>
      </main>
    </>
  )
}
