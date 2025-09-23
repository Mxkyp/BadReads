import './index.css'
import { Link } from "react-router";
import logoUrl from '/src/assets/logo.png'
export default function LoginPage() {
  return (
    <>
      {/*
        This example requires updating your template:

        ```
        <html class="h-full bg-gray-900">
        <body class="h-full">
        ```
      */}
      <div className="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8">
        <div className="sm:mx-auto sm:w-full sm:max-w-sm">
          <img
            alt="Your Company"
            src={logoUrl}
            className="mx-auto h-50 w-auto"
          />
          <h2 className="mt-10 text-center text-2xl/9 font-bold tracking-tight text-white">Sign in to your account</h2>
        </div>

        <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
          <form action="#" method="POST" className="space-y-6">
            <div>
              <label htmlFor="email" className="block text-sm/6 font-medium text-gray-900">
                Email address
              </label>
              <div className="mt-2">
                <input
                  id="email"
                  name="email"
                  type="email"
                  required
                  autoComplete="email"
                  className="block w-full rounded-md bg-white/5 px-3 py-1.5 text-base text-black outline-1 -outline-offset-1 outline-[var(--color-medium)]/40 placeholder:text-gray-900 focus:outline-2 focus:-outline-offset-2 focus:outline-[var(--color-medium)] sm:text-sm/6"
                />
              </div>
            </div>

            <div>
              <div className="flex items-center justify-between">
                <label htmlFor="password" className="block text-sm/6 font-medium text-gray-900">
                  Password
                </label>
                <div className="text-sm">
                  <a href="#" className="font-semibold text-[var(--color-dark)] hover:text-[var(--color-medium)]">
                    Forgot password?
                  </a>
                </div>
              </div>
              <div className="mt-2">
                <input
                  id="password"
                  name="password"
                  type="password"
                  required
                  autoComplete="current-password"
                  className="block w-full rounded-md bg-white/5 px-3 py-1.5 text-base text-black outline-1 -outline-offset-1 outline-[var(--color-medium)]/40 placeholder:text-gray-900 focus:outline-2 focus:-outline-offset-2 focus:outline-[var(--color-medium)] sm:text-sm/6"
                />
              </div>
            </div>

            <div>
              <button
                type="submit"
                className="flex w-full justify-center rounded-md bg-[var(--color-dark)] px-3 py-1.5 text-sm/6 font-semibold text-white hover:bg-[var(--color-medium)] focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-[var(--color-dark)]"
              >
                Sign in
              </button>
            </div>
          </form>

          <p className="mt-10 text-center text-sm/6 text-gray-400 ">
            Not a member?{' '}
            <Link to="#" className="font-semibold text-[var(--color-dark)] hover:text-[var(--color-medium)]">
              Sign up! :) 
            </Link>
          </p>
        </div>
      </div>
    </>
  )
}
