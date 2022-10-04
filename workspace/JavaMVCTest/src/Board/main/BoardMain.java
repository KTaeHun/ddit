package Board.main;

import java.util.List;
import java.util.Scanner;

import Board.service.BoardService;
import Board.service.BoardServiceImpl;
import Board.vo.BoardVO;

public class BoardMain {
			
		private Scanner scan = new Scanner(System.in);
		private BoardService boardService;
		
		
		
		public BoardMain() {
			boardService = new BoardServiceImpl();
		}

		public void displayMenu(){
			System.out.println();
			System.out.println("----------------------");
			System.out.println("  === 작 업 선 택 ===");
			System.out.println("  1. 새글 작성");
			System.out.println("  2. 글 삭제");
			System.out.println("  3. 글 수정");
			System.out.println("  4. 전체 자료 출력");
			System.out.println("  5. 자료 검색.");
			System.out.println("  6. 작업 끝.");
			System.out.println("----------------------");
			System.out.print("원하는 작업 선택 >> ");
		}
		
		/**
		 * 프로그램 시작메서드
		 */
		public void start(){
			int choice;
			do{
				displayMenu(); //메뉴 출력
				choice = scan.nextInt(); // 메뉴번호 입력받기
				switch (choice){
					case 1 :  // 새글 입력
						insertBoard();
						break;
					case 2 :  // 글 삭제
						deleteBoard();
						break;
					case 3 :  // 글 수정
						updateBoard();
						break;
					case 4 :  // 전체 자료 출력
						displayBoardAll();
						break;
					case 5 :  // 자료 검색
						searchBoard();
						break;
					case 6 :  // 작업 끝
						System.out.println("작업을 마칩니다.");
						break;
					default :
						System.out.println("게시판 번호를 잘못 입력했습니다. 다시입력하세요");
				}
			}while (choice != 6);
		}

		
		private void insertBoard() {
			
			boolean chk = false;
			
			int boardNo = 1;
			
			do {
//				System.out.println();
//				System.out.println("등록할 게시판 정보를 입력하세요.");
//				System.out.print("게시판 번호 >> ");
//				
//				boardNo = scan.nextInt();
				
				chk = checkBoard(boardNo);
				
				if (chk == true) {
//					System.out.println("게시판 번호가 " + boardNo + "인 글은 이미 존재합니다.");
//					System.out.println("다시 입력해 주세요.");
					boardNo++;
				}
			} while(chk == true);	
			
				System.out.print("제목 >> ");
				String boardTitle = scan.next();

				System.out.print("작성자 >> ");
				String boardWriter = scan.next();

				scan.nextLine(); // 입력버퍼 비우기

				System.out.print("작성 날짜 >> ");
				String boardDate = scan.nextLine();

				System.out.print("내용 >> ");
				String boardContent = scan.nextLine();

				BoardVO bv = new BoardVO();
				bv.setBoardNo(boardNo);
				bv.setBoardTitle(boardTitle);
				bv.setBoardWriter(boardWriter);
				bv.setBoardDate(boardDate);
				bv.setBoardContent(boardContent);

				int cnt = boardService.registerBoard(bv);

				if (cnt > 0) {
					System.out.println(boardNo + "번 게시글 등록 성공!");
				} else {
					System.out.println(boardNo + "번 게시글 등록 실패!!!");
				}
			}
		
		private boolean checkBoard(int boardNo) {
			
			boolean chk = boardService.checkBoard(boardNo);
					
			return chk;
		}
		
		private void updateBoard() {
			
			boolean chk = false;

			int boardNo = 0;

			do {
				System.out.println();
				System.out.println("수정할 글 정보를 입력하세요.");
				System.out.print("게시판 번호 >> ");

				boardNo = scan.nextInt();

				chk = checkBoard(boardNo);

				if (chk == false) {
					System.out.println("게시판 번호가 " + boardNo + "인  글이 존재하지 않습니다.");
					System.out.println("다시 입력해 주세요.");
				}

			} while (chk == false);

			System.out.print("제목 >> ");
			String boardTitle = scan.next();

			System.out.print("작성자 >> ");
			String boardWriter = scan.next();
			
			System.out.print("작성 날짜 >> ");
			String boardDate = scan.next();

			scan.nextLine(); // 입력버퍼 비우기

			System.out.print("내용 >> ");
			String boardContent = scan.nextLine();
			
			BoardVO bv = new BoardVO();
			bv.setBoardNo(boardNo);
			bv.setBoardTitle(boardTitle);
			bv.setBoardWriter(boardWriter);
			bv.setBoardDate(boardDate);
			bv.setBoardContent(boardContent);
					
			int cnt = boardService.modifyBoard(bv);
			
			if (cnt > 0) {
				System.out.println(boardNo + "번 글 수정 성공!");
			} else {
				System.out.println(boardNo + "번 글 수정 실패!!!");
			}
		}
		
		private void deleteBoard() {
			System.out.println();
			System.out.println("삭제할 글 정보를 입력하세요.");
			System.out.print("게시판 번호 >> ");
			
			int boardNo = scan.nextInt();
			
			int cnt = boardService.removeBoard(boardNo);
			
			if (cnt > 0) {
				System.out.println(boardNo + "번 글 삭제 성공!");
			} else {
				System.out.println(boardNo + "번 글  삭제 실패!!!");
			}
		}
		
			private void displayBoardAll() {
			System.out.println();
			System.out.println("--------------------------------------------------------");
			System.out.println(" 번호\t제  목\t작 성 자\t작성 날짜\t\t\t내 용");
			System.out.println("--------------------------------------------------------");
		
			List<BoardVO> boardList = boardService.getAllBoardList();
			
			if(boardList.size() == 0) {
				System.out.println(" 출력할 글이 없습니다.");
			} else {
				for(BoardVO bv : boardList) {
					System.out.println(" " + bv.getBoardNo() + "\t" + bv.getBoardTitle() + "\t"
							+ bv.getBoardWriter() + "\t" + bv.getBoardDate() +
							"\t" + bv.getBoardContent());
				}
			}
			System.out.println("--------------------------------------------------------");
			System.out.println("출력 끝.");
		}
		
		private void searchBoard() {
	
			scan.nextLine();  // 입력버퍼 비우기
			System.out.println();
			System.out.println("검색할 정보를 입력하세요.");
			System.out.print("게시판 번호 >> ");
			int boardNo = scan.nextInt();
			scan.nextLine();
			System.out.print("제목 >> ");
			String boardTitle = scan.nextLine().trim(); // 양쪽 공백제거
			System.out.print("작성자 >> ");
			String boardWirter = scan.nextLine().trim();
			System.out.print("작성 날짜 >> ");
			String boardDate = scan.nextLine().trim();
			System.out.print("내용 >> ");
			String boardContent = scan.nextLine().trim();
			
			BoardVO bv = new BoardVO();
			bv.setBoardNo(boardNo);
			bv.setBoardTitle(boardTitle);
			bv.setBoardWriter(boardWirter);
			bv.setBoardDate(boardDate);
			bv.setBoardContent(boardContent);
		
			List<BoardVO> boardList = boardService.searchBoardList(bv); 
			
			System.out.println();
			System.out.println("--------------------------------------------------------");
			System.out.println(" 번호\t제  목\t작 성 자\t작성 날짜\t\t\t내 용");
			System.out.println("--------------------------------------------------------");
						
			if(boardList.size() == 0) {
				System.out.println(" 검색된 글이 없습니다.");
			} else {
				for(BoardVO bv2 : boardList) {
					System.out.println(" " + bv2.getBoardNo() + "\t" + bv2.getBoardTitle() + "\t"
							+ bv2.getBoardWriter() + "\t" + bv2.getBoardDate() +
							"\t" + bv2.getBoardContent());
				}
			}
			System.out.println("--------------------------------------------------------");
			System.out.println("출력 끝.");
		}
		
		public static void main(String[] args) {
			BoardMain boardObj = new BoardMain();
			boardObj.start();
		}
		
		
}
